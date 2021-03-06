var contactAddEditController;

contactAddEditController = function($scope, contactService, $state) {
	$scope.contact = {};
	$scope.contact.emails = [''];
	$scope.contact.phones = [''];
	$scope.submitted = false;

	if($state.params.contactId != null && $state.params.contactId != '') {
	    contactService.getContactById($state.params.contactId).then(
            function success(res){
                $scope.contact = res.data;
            },
            function error(err) {
                console.error("falha ao carregar contato: " + err.data);
                alert(err.data);
            }
        )
	}

	$scope.save = function() {
		$scope.submitted = true;
		if ($scope.contact.name != null && $scope.contact.name != "") {
		    contactService.createContact($scope.contact).then(
                function success(res){
                    $state.go('main.contacts')
                },
                function error(err) {
                    console.error("falha ao cadastrar um contato: " + err.data);
                    alert(err.data);
                }
		    )
		}
	};

	$scope.addMorePhones = function() {
		$scope.contact.phones.push('');
	}; 

	$scope.addMoreEmails = function() {
		$scope.contact.emails.push('');
	};

	$scope.deletePhone = function(index){
		if (index > -1) {
    		$scope.contact.phones.splice(index, 1);
		}

		if ($scope.contact.phones.length < 1){
			$scope.addMorePhones();
		}
	};

	$scope.deleteEmail = function(index){
		if (index > -1) {
    		$scope.contact.emails.splice(index, 1);
		}

		if ($scope.contact.emails.length < 1){
			$scope.addMoreEmails();
		}
	};

};

angular.module('avaliacandidatos').controller("contactAddEditController", contactAddEditController);