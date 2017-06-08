var contactService;

contactService = function($http) {
    var service = {
        createContact: createContact,
        listContacts: listContacts,
        deleteContact: deleteContact
    };

    function createContact(contact) {
         var url = '/contacts';
         return $http.post(url, contact);
    }

    function listContacts() {
         var url = '/contacts';
         return $http.get(url);
    }

    function deleteContact(contactId) {
         var url = '/contacts?id=' + contactId;
         return $http.delete(url);
    }


    return service;
};

angular.module('avaliacandidatos').service("contactService", contactService);