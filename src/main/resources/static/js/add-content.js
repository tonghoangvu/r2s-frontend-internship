'use strict'

$(document).ready(() => {
	$('#form').submit(() => {
		const formData = collectFormData()
		const errorMessage = validateFormData(formData)
		if (errorMessage) {
			handleError(errorMessage)
			return false
		}
		$.post('/content', formData, () => {
			window.location.replace('/view-content.html')
		}).fail(error => {
			handleError(error['responseJSON'].message)
		})
		return false
	})
})

function collectFormData() {
	const title = $('#title').val()
	const brief = $('#brief').val()
	const content = $('#content').val()
	const createdDate = formatDate(new Date())
	return {title, brief, content, createdDate}
}

function formatDate(date) {
	const day = date.getDate().toString().padStart(2, '0')
	const month = (date.getMonth() + 1).toString().padStart(2, '0')
	const year = date.getFullYear().toString().padStart(4, '0')
	const hours = date.getHours().toString().padStart(2, '0')
	const minutes = date.getMinutes().toString().padStart(2, '0')
	return `${day}/${month}/${year} ${hours}:${minutes}`
}

function validateFormData(formData) {
	if (isStringBlank(formData.title))
		return 'Title is required'
	if (isStringLengthNotInRange(formData.title, 10, 200))
		return 'Title must be between 10 and 200 characters long'

	if (isStringBlank(formData.brief))
		return 'Brief is required'
	if (isStringLengthNotInRange(formData.brief, 30, 150))
		return 'Brief must be between 30 and 150 characters long'

	if (isStringBlank(formData.content))
		return 'Content is required'
	if (isStringLengthNotInRange(formData.content, 50, 1000))
		return 'Content must be between 50 and 1000 characters long'

	return null
}

function handleError(message) {
	const errorMessageElement = $('#error-message')
	errorMessageElement.removeClass('d-none')
	errorMessageElement.text(message)
}
