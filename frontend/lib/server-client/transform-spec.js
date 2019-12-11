const spec = require('./spec.json');

for (const [path, methodsObj] of Object.entries(spec.paths)) {
	for (const [method, endpointObj] of Object.entries(methodsObj)) {
		endpointObj.tags = [path.replace(/^api\//g, '')];

		for (const param of endpointObj.parameters || []) {
			if (param.name === 'pageable')
				param.required = false;
		}
	}
}


console.log(JSON.stringify(spec))
