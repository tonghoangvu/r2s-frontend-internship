'use strict'

$(document).ready(() => {
	loadCurrentProfile()
	$('#form').submit(() => {
		const formData = collectFormData()
		const errorMessage = validateFormData(formData)
		if (errorMessage) {
			handleError(errorMessage)
			return false
		}
		$.ajax('/profile', {
			method: 'put',
			url: '/profile',
			data: formData,
			success: data => {
				handleSuccess('Your profile has been updated')
				loadProfileData(data)
			},
			error: error => {
				handleError(error['responseJSON'].message)
			}
		})
		return false
	})
})

function loadCurrentProfile() {
	$.get('/profile', data => {
		loadProfileData(data)
	}).fail(error => {
		handleError(error['responseJSON'].message)
	})
}

function loadProfileData(data) {
	$('#first-name').val(data['firstName'])
	$('#last-name').val(data['lastName'])
	$('#email').text(data['email'])
	$('#phone').val(data['phone'])
	$('#description').val(data['description'])
}

function collectFormData() {
	const firstName = $('#first-name').val()
	const lastName = $('#last-name').val()
	const phone = $('#phone').val()
	const description = $('#description').val()
	return { firstName, lastName, phone, description }
}

function validateFormData(formData) {
	if (isStringBlank(formData.firstName))
		return 'First name is required'
	if (isStringLengthNotInRange(formData.firstName, 3, 30))
		return 'First name must be between 3 and 30 characters long'

	if (isStringBlank(formData.lastName))
		return 'Last name is required'
	if (isStringLengthNotInRange(formData.lastName, 3, 30))
		return 'Last name must be between 3 and 30 characters long'

	if (isStringBlank(formData.phone))
		return 'Phone is required'
	if (isStringLengthNotInRange(formData.phone, 9, 13))
		return 'Phone must be between 9 and 13 characters long'

	if (isStringTooLong(formData.description, 200))
		return 'Description must be 200 characters or less'

	return null
}

function handleError(message) {
	const errorMessageElement = $('#error-message')
	errorMessageElement.removeClass('d-none')
	errorMessageElement.text(message)
}

function handleSuccess(message) {
	const successMessageElement = $('#success-message')
	successMessageElement.removeClass('d-none')
	successMessageElement.text(message)
}
