'use strict'

$(document).ready(() => {
	loadContentData()
	setTimeout(() => {
		displayContent()
	}, 5000)
})

function loadContentData() {
	$.get('/content', data => {
		loadDataToUI(data)
	}).fail(error => {
		handleError(error['responseJSON'].message)
	})
}

function loadDataToUI(data) {
	const table = document.getElementById('table')
	table.textContent = ''
	for (const item of data) {
		const colId = document.createElement('td')
		const colTitle = document.createElement('td')
		const colBrief = document.createElement('td')
		const colCreatedDate = document.createElement('td')

		colId.textContent = item.id
		colTitle.textContent = item.title
		colBrief.textContent = item.brief
		colCreatedDate.textContent = item.createdDate

		const row = document.createElement('tr')
		row.appendChild(colId)
		row.appendChild(colTitle)
		row.appendChild(colBrief)
		row.appendChild(colCreatedDate)

		table.appendChild(row)
	}
}

function handleError(message) {
	const errorMessageElement = $('#error-message')
	errorMessageElement.removeClass('d-none')
	errorMessageElement.text(message)
	return false
}

function displayContent() {
	$('#loading').addClass('d-none')
	$('#title').removeClass('d-none')
	$('#content').removeClass('d-none')
}
