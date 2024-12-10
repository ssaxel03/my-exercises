const genericService = function (name) {

    let serviceName = name;
    const map = []

    return {
        name: function() {
            return serviceName;
        },
        add: function(id, newItem) {
            map.push({id: id, value: newItem});
        },
        remove: function(id) {
            let index = map.findIndex((element) => element.id = id);
            map.remove(index);
        },
        destroy: function() {
            map = [];
        },
        update: function(id, newValue) {
            let index = map.findIndex((element) => element.id = id);
            map[index] = newValue;
        },
        get: function (id) {
            let index = map.findIndex((element) => element.id = id);
            return map[index];
        },
        list: function () {
            return map;
        }
    };
}

let contacts = genericService("contactList");

contacts.add(1, "Igor");
contacts.add(2, "Cristina");
contacts.add(7000, "Axel");
contacts.add(65, "Nuno");

console.log(contacts.get(1));

console.log(contacts.list());

console.log(contacts.serviceName);

console.log(contacts.map);