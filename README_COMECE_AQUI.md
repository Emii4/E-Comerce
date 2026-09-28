# LOJA ESCOLA - PROJETO-MODELO REVISADO

Um ponto de partida opcional para grupos do 2º ano criarem seu próprio e-commerce.
Aqui usamos Java + Spring Boot, HTML/CSS/JS e banco SQL H2 para reduzir a quantidade de instalações.

## O que já funciona
- Catálogo de 3 produtos em `http://localhost:8080`.
- API Java de consulta `GET /api/produtos`.
- Cadastro demonstrativo via `POST /api/produtos` e formulário da página.
- Banco H2 em `dados/loja.mv.db` que mantém os produtos após reiniciar.
- Carrinho temporário, apenas no navegador.

## PRIMEIRO DIA (WINDOWS)
1. Abra a pasta no VS Code.
2. Verifique `java -version` e `javac -version` (JDK 17+).
3. Execute `INICIAR_NO_WINDOWS.bat` ou `mvn spring-boot:run`.
4. Acesse `http://localhost:8080`.
5. Abra também `http://localhost:8080/api/produtos`.

## PRIMEIRO DIA (LINUX/MAC)
Com JDK 17+ e Maven instalados, use `bash INICIAR_LINUX_MAC.sh`.

## MAPA DE ARQUIVOS
- `index.html`: conteúdo da página.
- `estilo.css`: aparência.
- `loja.js`: ponte entre página e API Java.
- `Produto.java`: classe POO.
- `ProdutoRepository.java`: interface do banco.
- `ProdutoController.java`: endpoints GET/POST.
- `application.properties`: configurações locais e H2.
- `CargaInicial.java`: 3 produtos iniciais.

## CUIDADOS
- Não use dados pessoais reais.
- Não publique esta versão.
- O carrinho não realiza compras reais.
