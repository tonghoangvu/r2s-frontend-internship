$(document).ready(() => {
	loadProfileData()
})

function loadProfileData() {
	$.get('/profile', data => {
		$('#first-name').val(data['firstName'])
		$('#last-name').val(data['lastName'])
		$('#email').text(data['email'])
		$('#phone').val(data['phone'])
		$('#description').val(data['description'])
	}).fail(error => {
		handleError(error['responseJSON'].message)
	})
}

function handleError(message) {
	const errorMessageElement = $('#error-message')
	errorMessageElement.removeClass('d-none')
	errorMessageElement.text(message)
	return false
}
