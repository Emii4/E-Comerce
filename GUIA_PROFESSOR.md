# GUIA DO PROFESSOR - MATERIAL REVISADO

## Revisões técnicas feitas
- Mantidas só duas rotas REST (GET/POST).
- A classe `Produto` tem campos privados e limites de coluna.
- O Controller valida nome, preço e estoque.
- O formulário reflete as mesmas regras.
- O Maven está configurado com addResources.
- O JavaScript usa `textContent` para evitar HTML injection.
- O banco é H2 persistente local.
- O console SQL e o servidor ficam acessíveis somente no próprio computador.

## Antes de ir à sala
1. Teste `java -version` + `javac -version`.
2. Extraia e tente `INICIAR_NO_WINDOWS.bat`.
3. Verifique a porta 8080.
4. Confirme `http://localhost:8080` e `/api/produtos`.

## AULA 1
0-10 min: objetivo e fluxo na lousa.
10-40 min: abrir editor, iniciar servidor e visitar loja + JSON.
40-50 min: registrar 2 evidências.

## AULA 2
10-40 min: cadastro demonstrativo pelo formulário.
40-50 min: explicar frontend, backend, banco e persistência.
