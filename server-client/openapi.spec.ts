import { OpenAPIObject } from 'openapi3-ts';

const spec: OpenAPIObject = {
  openapi: '3.0.0',
  info: {
    title: 'ListAval',
    description: 'API gerenciamento de avaliações de lista',
    version: '0.0.1',
  },
  servers: [{ url: 'http://localhost:8080/api' }],
  components: {
    parameters: {},
		responses: {},
		schemas: {},
  },
};

console.log(spec);
