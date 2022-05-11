function Validator(options) {
    function getParent(element, selector) {
        while (element.parentElement) {
            if(element.parentElement.matches(selector)) {
                return element.parentElement
            }
            element = element.parentElement
        }
    }

    var selectorRules = {}
    //ham thuc hien validate
    function validate(inputElement, rule) {
        var errorMessage
        var errorElement = getParent(inputElement, options.formGroupSelector).querySelector(options.errorSelector)
        var rules = selectorRules[rule.selector]

        for (let index = 0; index < rules.length; index++) {
            errorMessage = rules[index](inputElement.value)
            if (errorMessage) break
        }

        if(errorMessage) {
            errorElement.innerText = errorMessage
            getParent(inputElement, options.formGroupSelector).classList.add('invalid')
        } else {
            errorElement.innerText = ''
            getParent(inputElement, options.formGroupSelector).classList.remove('invalid')
        }
    }
    // lay element cua form can validate
    var formElement = document.querySelector(options.form)

    if (formElement) {
        formElement.onsubmit = function (e) {
            e.preventDefault();
            options.rules.forEach(function (rule) {
                var inputElement = formElement.querySelector(rule.selector)
                validate(inputElement, rule)
            })
        }
        // xử lý lặp qua mỗi rule ( lắng nghe sự kiện)
        options.rules.forEach(rule => {
            // lưu lại các rule của mỗi thẻ input
            if(Array.isArray(selectorRules[rule.selector])){
                selectorRules[rule.selector].push(rule.test)
            } else {
                selectorRules[rule.selector] = [rule.test]
            }

            var inputElement = formElement.querySelector(rule.selector)
            if (inputElement) {
                // xử lý trường hợp blur hỏi input
                inputElement.onblur = () => {
                    validate(inputElement, rule)
                }
                //xử lý TH mỗi khi người dùng nhập vào input
                inputElement.oninput = function () {
                    var errorElement = getParent(inputElement, options.formGroupSelector).querySelector(options.errorSelector)
                    errorElement.innerText = ''
                    getParent(inputElement, options.formGroupSelector).classList.remove('invalid')
                }
            }
        });
    }
}
Validator.isRequired = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined : message ||  'Vui long nhập trường này'
        }
    }
}
Validator.isEmail = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
            return regex.test(value) ? undefined : message || 'Trường này phải là email'
        }
    }
}
Validator.minLength = function (selector, min, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.length >= min ? undefined : message ||  `Mật khẩu phải chứa tối thiểu ${min} ký tự`
        }
    }
}
Validator.isConfirmed = function (selector, getConfirmValue, message) {
    return {
        selector: selector,
        test: function (value) {
            return value === getConfirmValue() ? undefined : message || 'Giá trị nhập lại không chính xác'
        }
    }
}