


O desafio consiste em desenvolver um programa Java que analisa uma página HTML a partir de uma URL e retorna o trecho de texto no nível mais profundo da estrutura HTML. Além disso, existem algumas restrições importantes:

Apenas Java Puro: Sem bibliotecas externas ou classes do JDK para manipulação de HTML/XML/DOM.
Compilação e Execução Simples: O programa deve ser compilável e executável com javac e java sem modificações.
Regras de Identificação:
As tags HTML são bem formatadas (abertura e fechamento).
O texto dentro do HTML está em diferentes níveis de aninhamento.
Deve retornar o primeiro texto do nível mais profundo.
Pode retornar "malformed HTML" se optar por validar HTML incorreto.
Deve tratar erros de conexão com "URL connection error".
