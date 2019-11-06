
  export interface Lista {
      id: number;
      questoes?: any;
      dataCadastro: Date;
      usuarioCadastro: string;
      dataAlteracao: Date;
      usuarioAlteracao: string;
  }

  export interface Disciplina {
      id: number;
      nome: string;
      dataCadastro: Date;
      usuarioCadastro: string;
      dataAlteracao: Date;
      usuarioAlteracao: string;
  }

  export interface Docente {
      dtype: string;
      id: number;
      nome: string;
      email: string;
      senha?: any;
  }

  export interface Turma {
      id: number;
      disciplina: Disciplina;
      semestre: string;
      docente: Docente;
      discentes?: any;
  }

  export interface AplicacaoLista {
      id: number;
      lista: Lista;
      turma: Turma;
      resolucoes?: any;
      dataCadastro: Date;
      usuarioCadastro: string;
  }

  export interface Discente {
      dtype: string;
      id: number;
      nome: string;
      email: string;
      senha?: any;
      resolucoes?: any;
  }

  export interface ResolucaoItem {
      id: number;
      aplicacaoLista: AplicacaoLista;
      discente: Discente;
      respostas?: any;
      dataCadastro: Date;
      dataAlteracao: Date;
  }

  export interface Sort {
      sorted: boolean;
      unsorted: boolean;
      empty: boolean;
  }

  export interface Pageable {
      sort: Sort;
      pageSize: number;
      pageNumber: number;
      offset: number;
      paged: boolean;
      unpaged: boolean;
  }

  export interface Sort2 {
      sorted: boolean;
      unsorted: boolean;
      empty: boolean;
  }

  export interface Resolucao {
      content: ResolucaoItem[];
      pageable: Pageable;
      totalPages: number;
      totalElements: number;
      last: boolean;
      first: boolean;
      sort: Sort2;
      number: number;
      numberOfElements: number;
      size: number;
      empty: boolean;
  }



