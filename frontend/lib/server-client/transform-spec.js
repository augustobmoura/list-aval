const spec = require('./spec.json');

const capitalize = str => (str && str[0].toUpperCase() + str.substring(1)) || '';

for (const [path, methodsObj] of Object.entries(spec.paths)) {
  for (const [method, endpointObj] of Object.entries(methodsObj)) {
    const tag = path.replace(/(\/api\/\w+\/).*/g, '$1').replace(/\//g, ' ').trim();
    const ns = tag.replace(/^\w+ /, '');
    endpointObj.tags = [tag];
    endpointObj.operationId = endpointObj.operationId.replace(/\d+$/g, capitalize(ns));

    for (const param of endpointObj.parameters || []) {
      if (param.name === 'pageable')
        param.required = false;
    }
  }
}

console.log(JSON.stringify(spec));
