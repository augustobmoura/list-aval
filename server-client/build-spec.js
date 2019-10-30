const { exec } = require('child_process');

const proc = exec('java ' + [
	'-jar', 'openapi-generator-cli.jar',
	'generate',
	'-i', 'http://localhost:8080/v3/api-docs',
	'-g', 'typescript-angular',
	'-o', 'generated-src',
].join(' '))

proc.stdout.on('data', (data) => {
	process.stdout.write(data)
})

proc.stderr.on('data', (data) => {
	process.stderr.write(data)
})

proc.on('close', code => process.exit(code))
