const nconf = require('nconf');

let config = () => {

    let environment = nconf.get('NODE_ENV') || 'development';
    nconf.argv().env('_');
    nconf.file(environment, 'config/' + environment + '.json');
    nconf.file('default', 'config/default.json');

    let get = (key) => {
        return nconf.get(key);
    };

    return {
        get: get
    };
}

module.exports = config;