'use strict'

$(document).ready(() => {
	$('#form').submit(() => {
		const formData = collectFormData()
		const errorMessage = validateFormData(formData)
		if (errorMessage) {
			handleError(errorMessage)
			return false
		}
		$.post('/register', formData, () => {
			window.location.replace('/login.html')
		}).fail(error => {
			handleError(error['responseJSON'].message)
		})
		return false
	})
})

function collectFormData() {
	const username = $('#username').val()
	const email = $('#email').val()
	const password = $('#password').val()
	const repassword = $('#repassword').val()
	return { username, email, password, repassword }
}

function validateFormData(formData) {
	if (isStringBlank(formData.username))
		return 'Username is required'
	if (isStringLengthNotInRange(formData.username, 3, 30))
		return 'Username must be between 3 and 30 characters long'

	if (isStringBlank(formData.email))
		return 'Email is required'
	if (isStringTooShort(formData.email, 5))
		return 'Email must be 5 characters or more'
	if (isEmailInvalid(formData.email))
		return 'Email is invalid'

	if (isStringBlank(formData.password))
		return 'Password is required'
	if (isStringLengthNotInRange(formData.password, 8, 30))
		return 'Password must be between 8 and 30 characters long'

	if (formData.password !== formData.repassword)
		return 'Password and repassword do not match'

	return null
}

function handleError(message) {
	const errorMessageElement = $('#error-message')
	errorMessageElement.removeClass('d-none')
	errorMessageElement.text(message)
}
