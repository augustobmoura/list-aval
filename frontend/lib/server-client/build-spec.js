const { exec } = require('child_process');

const specFileLocation = 'http://localhost:8080/v3/api-docs';

const proc = exec('java ' + [
  '-jar', 'openapi-generator-cli.jar',
  'generate',
  '-i', specFileLocation,
  '-g', 'typescript-angular',
  '-o', 'generated-src',
].join(' '));

proc.stdout.on('data', (data) => {
  process.stdout.write(data);
});

proc.stderr.on('data', (data) => {
  process.stderr.write(data);
});

proc.on('close', code => process.exit(code));
