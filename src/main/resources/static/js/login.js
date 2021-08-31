'use strict'

$(document).ready(() => {
	if (checkPageError())
		handleError('Username and password do not match')
	$('#form').submit(() => {
		const formData = collectFormData()
		const errorMessage = validateFormData(formData)
		if (errorMessage)
			return handleError(errorMessage)
	})
})

function checkPageError() {
	return new URLSearchParams(window.location.search).get('error') === 'true'
}

function collectFormData() {
	const email = $('#email').val()
	const password = $('#password').val()
	return { email, password }
}

function validateFormData(formData) {
	if (isStringBlank(formData.email))
		return 'Email is required'
	if (isStringLengthNotInRange(formData.email, 5, 50))
		return 'Email must be between 5 and 50 characters long'
	if (isEmailInvalid(formData.email))
		return 'Email is invalid'

	if (isStringBlank(formData.password))
		return 'Password is required'
	if (isStringLengthNotInRange(formData.password, 8, 30))
		return 'Password must be between 8 and 30 characters long'

	return null
}

function handleError(message) {
	const errorMessageElement = $('#error-message')
	errorMessageElement.removeClass('d-none')
	errorMessageElement.text(message)
	return false
}
