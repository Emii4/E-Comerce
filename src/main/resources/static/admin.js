<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Administração - Loja Escola</title>
  <link rel="stylesheet" href="/estilo.css" />
  <style>
    .admin-layout {
      display: grid;
      grid-template-columns: 1.1fr 1.5fr;
      gap: 24px;
    }
    .lista-admin {
      display: grid;
      gap: 14px;
    }
    .item-admin {
      border: 1px solid var(--cor-borda);
      border-radius: 12px;
      padding: 14px;
      background: #fff;
    }
    .acoes {
      display: flex;
      gap: 8px;
      margin-top: 12px;
      flex-wrap: wrap;
    }
    .btn-secundario {
      background: #2f2f3a;
    }
    .btn-danger {
      background: #b5121b;
    }
  </style>
</head>
<body>
  <header class="topo">
    <div class="container">
      <h1>Administração de Produtos</h1>
      <p>Cadastro, edição e exclusão do catálogo</p>
    </div>
  </header>

  <main class="container" style="padding-top: 30px;">
    <div class="admin-layout">
      <section class="painel">
        <h2 id="tituloFormulario">Cadastrar produto</h2>
        <form id="formProduto" class="formulario">
          <input type="hidden" id="idProduto" />

          <div class="campo">
            <label for="nome">Nome</label>
            <input id="nome" name="nome" type="text" required />
          </div>

          <div class="campo">
            <label for="descricao">Descrição</label>
            <textarea id="descricao" name="descricao" rows="3" required></textarea>
          </div>

          <div class="linha-dupla">
            <div class="campo">
              <label for="preco">Preço</label>
              <input id="preco" name="preco" type="number" min="0.01" step="0.01" required />
            </div>
            <div class="campo">
              <label for="estoque">Estoque</label>
              <input id="estoque" name="estoque" type="number" min="0" step="1" required />
            </div>
          </div>

          <div class="linha-dupla">
            <div class="campo">
              <label for="marca">Marca</label>
              <input id="marca" name="marca" type="text" required />
            </div>
            <div class="campo">
              <label for="categoria">Categoria</label>
              <input id="categoria" name="categoria" type="text" value="Smartphones" required />
            </div>
          </div>

          <div class="campo">
            <label for="imagem">Imagem</label>
            <input id="imagem" name="imagem" type="url" required />
          </div>

          <div class="acoes">
            <button type="submit">Salvar</button>
            <button type="button" class="btn-secundario" id="btnCancelar">Cancelar</button>
          </div>
          <p id="mensagem" class="mensagem" aria-live="polite"></p>
        </form>
      </section>

      <section class="catalogo">
        <div class="cabecalho-catalogo">
          <h2>Produtos cadastrados</h2>
          <a href="/" style="color: var(--cor-principal); font-weight: 700; text-decoration: none;">Voltar para loja</a>
        </div>
        <div id="listaProdutos" class="lista-admin"></div>
      </section>
    </div>
  </main>

  <script src="/admin.js"></script>
</body>
</html>
