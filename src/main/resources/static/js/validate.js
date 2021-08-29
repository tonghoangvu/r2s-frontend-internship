function isEmpty(value) {
	return value === undefined || value === null
}

function isStringBlank(str) {
	return isEmpty(str) || str === ''
}

function isStringTooShort(str, min) {
	return str.length < min
}

function isStringTooLong(str, max) {
	return str.length > max
}

function isStringLengthNotInRange(str, min, max) {
	return isStringTooShort(str, min) || isStringTooLong(str, max)
}

function isEmailInvalid(email) {
	const EMAIL_REGEX = /^([a-zA-Z0-9_.\-])+@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
	return !EMAIL_REGEX.test(email)
}
