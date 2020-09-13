function controller() {

	let _self = this;

	_self.url = 'http://localhost:8080/easyway/v1/customers';
	_self.CustomerInputDto = {
		name: '',
		cpf: '',
		email: '',		
		phoneNumber: '',
		customerType: '',
		creditAmount: ''
	}
	
	_self.nome = $('#name');
	_self.cpf = $('#cpf');
	_self.email = $('#email');
	_self.phoneNumber = $('#phone');	
	_self.creditAmount = $('#amount');	
	
	_self.simulate = $('#simulate');
	
	_self.btnSend = $('#send');
	_self.btnSendServer = $('#send-server');
	_self.valueAvailable = $('#value-available');
	_self.labelValue = $('#label-value');
	_self.labelAlert = $('#label-alert');
	_self.valueInputUser = $('#value-input-user');

	_self.load = () => {
		_self.simulate.maskMoney();
		
		_self.labelValue.hide();
		_self.labelAlert.hide();
	}

	
		_self.btnSend.click(item =>{
		_self.labelValue.hide();
		_self.labelAlert.hide();
		let valueFormat = _self.simulate.maskMoney('unmasked')[0];
		let upgradedValue = _self.upgradeValue(valueFormat);
		if (valueFormat <= 21000) {
			_self.valueInputUser.html(_self.simulate.val());
			_self.valueAvailable.html(upgradedValue);					
			_self.labelValue.show().delay(3000);
		} else {
			_self.labelAlert.show().delay(3000);
		}
	})

	_self.upgradeValue = (value) =>{
			let modifiedValue = value*0.09456;
			return modifiedValue.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'});
	}	

	_self.btnSendServer.click(function () {
			ajaxCenter(_self.url, _self.getModel(), false, "POST");
	})

	_self.getModel = () => {
		_self.CustomerInputDto.name = _self.nome.val();
		_self.CustomerInputDto.cpf = _self.cpf.val();
		_self.CustomerInputDto.email = _self.email.val();
		_self.CustomerInputDto.phoneNumber = parseInt(_self.phoneNumber.val());
		_self.CustomerInputDto.customerType = "MICROCREDIT";
		_self.CustomerInputDto.creditAmount = parseFloat(_self.creditAmount.val());

		return _self.CustomerInputDto;
	}

	_self.showMessage = (message, typeMessage) => {
		$('#message').remove();
		let template = `
		<div class='alert ${typeMessage}' id='message'>
			<strong>${message}</strong>
			<button type="button" class="close">
			<span aria-hidden="true">&times;</span>
		  </button>
		</div>`

		$('body').append(template);

		setTimeout(() => $('#message').remove(), 5000);

		$('.close').click(() => $('#message').remove())
	}

	 function ajaxCenter(url, parameter, asynchronous, typeRequest) {
		var handle201 = function(data, textStatus, jqXHR) {
			$('#message-ok').append($('<p>').html('Cadastro realizado com sucesso!'));
    		//alert('201'); // success codes have the success signature
    		// test it if you are in doubt:
    		//console.log(data);
    		//console.log(textStatus);
    		//console.log(jqXHR);
		}		
		
		return $.ajax({
			url: url,
			contentType: "application/json",
			data: typeRequest === "POST" ? JSON.stringify(parameter) : parameter,
			dataType: "text",
			async: asynchronous,
			cache: false,
			type: typeRequest,
			statusCode: {
				201: handle201
			}
		});
	}
}