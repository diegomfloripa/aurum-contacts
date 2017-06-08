var contactService;

contactService = function($http) {
    var service = {
        createContact: createContact,
        listContacts: listContacts,
        deleteContact: deleteContact,
        getContactById: getContactById
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

    function getContactById(contactId) {
         var url = '/contacts?id=' + contactId;
         return $http.get(url);
    }


    return service;
};

angular.module('avaliacandidatos').service("contactService", contactService);