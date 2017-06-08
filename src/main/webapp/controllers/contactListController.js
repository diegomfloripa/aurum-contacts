var contactListController;

contactListController = function($scope, contactService, $state) {
	$scope.contacts = [];
	$scope.preDeletedContact = {};

	$scope.init = function() {
		$scope.listAllContacts();
	};
	
	$scope.listAllContacts = function() {
        contactService.listContacts().then(
            function success(res){
                $scope.contacts = res.data;
            },
            function error(err) {
                console.error("falha ao obter lista de contatos: " + err.data);
                alert(err.data);
            }
        )
	};

	$scope.preDelete = function(contact) {
		$scope.preDeletedContact = contact;
		$('#myModal').modal('show');
	};

	$scope.delete = function() {
		if($scope.preDeletedContact != null) {
            contactService.deleteContact($scope.preDeletedContact.id).then(
                function success(res){
                     $('#myModal').modal('toggle');
                     $scope.init();
                },
                function error(err) {
                    console.error("falha ao deletar contato: " + err.data);
                    alert(err.data);
                }
            )
		}
	};

	$scope.openEdit = function(contact) {
    	var params = {'contactId': contact.id};
	    $state.go('main.addeditcontact', params);
	}

	$scope.bday = function(c) {
		if(c.birthDay==null || c.birthDay == ""){
			return "";
		} else {
			return c.birthDay + "/" + c.birthMonth + "/" + c.birthYear;
		}
	};
};

angular.module('avaliacandidatos').controller("contactListController", contactListController);