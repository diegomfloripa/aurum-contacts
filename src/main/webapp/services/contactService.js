var contactService;

contactService = function($http) {
    var service = {
        createContact: createContact,
        listContacts: listContacts
    };

    function createContact(contact) {
         var url = '/contacts';
         return $http.post(url, contact);
    }

    function listContacts() {
         var url = '/contacts';
         return $http.get(url);
    }

    return service;
};

angular.module('avaliacandidatos').service("contactService", contactService);