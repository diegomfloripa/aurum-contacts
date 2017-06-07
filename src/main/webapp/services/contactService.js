var contactService;

contactService = function($http) {
    var service = {
        createContact: createContact
    };

    function createContact(contact) {
         var url = '/contacts';
         return $http.post(url, contact);
    }

    return service;
};

angular.module('avaliacandidatos').service("contactService", contactService);