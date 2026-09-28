# VALIDAÇÃO E LIMITES DESTA REVISÃO

## Testes realizados
- `pom.xml` validado como XML.
- Código Java compilado com `javac` usando stubs locais.
- `CargaInicial` e `ProdutoController` testados com repositório simulado.
- `loja.js` validado com `node --check`.
- Script Linux validado com `bash -n`.

## O que ainda precisa de teste
- O professor deve iniciar o projeto no computador da escola com internet.
- Depois disso, verificar `java ferramentas/VerificarServidor.java`.

## Atenção ao ambiente escolar
- Internet e políticas de rede podem impedir o Maven no primeiro acesso.
- JDK 17 ou superior deve estar instalado.
- Se o laboratório bloquear instalação, utilize `PLANO_B_SEM_JAVA.html`.
