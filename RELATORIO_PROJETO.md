# Relatório do Projeto - Sistema de Gerenciamento

## 1. Identificação do Grupo
- **Integrantes:** [Nomes dos alunos]
- **Disciplina:** [Nome da disciplina]
- **Professor:** [Nome do professor]
- **Semestre:** [Ano/Semestre]

---

## 2. Processo de Instalação e Teste

### **Etapas Realizadas**
1. **Download do Projeto:**  
   O código fonte foi baixado/descompactado para a máquina local.
2. **Configuração do Ambiente:**  
   - Instalação do Java JDK 17.
   - Instalação do MySQL Server (ou PostgreSQL, se for o caso).
   - Instalação do VSCode (ou Eclipse) com extensões Java.
3. **Configuração do Banco de Dados:**  
   - Execução do arquivo `script.sql` para criar o banco e as tabelas.
   - Ajuste das credenciais de acesso ao banco no código (usuário, senha, URL).
4. **Build e Execução:**  
   - Compilação do projeto com Maven (`mvn clean package`).
   - Execução do sistema via arquivo `.bat` ou diretamente pelo JAR.
5. **Testes:**  
   - Cadastro de usuários, produtos, vendas e itens de venda.
   - Verificação do funcionamento das telas e persistência dos dados.

### **Problemas Encontrados e Soluções**
- **Erro de conexão:** Ajuste das credenciais e URL do banco.
- **Erro de formatação de valores:** Adaptação do código para aceitar vírgula e ponto em valores monetários.
- **Dependências:** Uso do Maven para baixar e gerenciar dependências.

---

## 3. Requisitos Funcionais e Não-Funcionais

### **Requisitos Funcionais**
- RF01: Cadastro de usuários.
- RF02: Cadastro de produtos.
- RF03: Registro de vendas.
- RF04: Registro de itens de venda.
- RF05: Visualização de extrato de vendas (quem vendeu, o que vendeu, quantidade, preço).

### **Requisitos Não-Funcionais**
- RNF01: Persistência dos dados em banco relacional (MySQL/PostgreSQL).
- RNF02: Interface gráfica amigável (Swing).
- RNF03: Código orientado a objetos.
- RNF04: Uso do padrão DAO para acesso a dados.
- RNF05: Compatibilidade com Java 17+.

---

## 4. Arquitetura Física e Lógica

### **Arquitetura Física**
- **Cliente:** Aplicação Java Desktop (Swing) rodando no computador do usuário.
- **Servidor:** Banco de dados MySQL/PostgreSQL local ou em servidor.

### **Arquitetura Lógica**
- **Camada de Apresentação:** Telas Swing (View)
- **Camada de Negócio:** Classes de modelo (Model)
- **Camada de Persistência:** DAOs (Data Access Object)
- **Banco de Dados:** Tabelas relacionais

#### **Descrição da Arquitetura de Software**
- Padrão MVC simplificado (View, Model, DAO)
- Separação clara entre interface, lógica de negócio e acesso a dados.

---

## 5. Propostas para a Segunda Parte

### **a) Segunda conexão com outro SGBD**
- Propor uso do padrão **Strategy** para alternar entre MySQL e PostgreSQL.
- Criar interface `ConexaoBD` e implementações para cada SGBD.

### **b) Paginação dos componentes de tela**
- Implementar paginação nas tabelas de listagem (ex: mostrar 10 itens por página).
- Adicionar botões "Próximo" e "Anterior".

### **c) Adequações na interface gráfica**
- Usar ComboBox para seleção de vendas/produtos.
- Exibir mensagens detalhadas de erro/sucesso.
- Adicionar filtros de busca e ordenação nas tabelas.
- Melhorar layout e responsividade das telas.

---

## 6. Sobre o Código Fonte

O projeto está organizado da seguinte forma:

- **src/main/java/com/sistema/view/**  
  Telas do sistema (Swing):  
  - `TelaPrincipal.java`, `TelaCadastroUsuario.java`, `TelaCadastroProduto.java`, `TelaCadastroVenda.java`, `TelaCadastroItemVenda.java`, `PainelFundo.java`

- **src/main/java/com/sistema/dao/**  
  DAOs para acesso ao banco:  
  - `UsuarioDAO.java`, `ProdutoDAO.java`, `VendaDAO.java`, `ItemVendaDAO.java`

- **src/main/java/com/sistema/model/**  
  Modelos de dados:  
  - `Usuario.java`, `Produto.java`, `Venda.java`, `ItemVenda.java`

- **src/main/java/com/sistema/util/**  
  Utilitários:  
  - `ConexaoBD.java` (responsável pela conexão com o banco)

- **src/main/resources/**  
  Recursos do projeto:  
  - `script.sql` (criação do banco e tabelas)
  - Imagens de ícones e logo

- **pom.xml**  
  Gerenciamento de dependências e build com Maven.

---

## 7. Estrutura do Banco de Dados

O banco possui as seguintes tabelas (ver `script.sql`):

- **usuarios:** id, nome, email, senha, data_cadastro
- **produtos:** id, nome, descricao, preco, quantidade, data_cadastro
- **vendas:** id, usuario_id, data_venda, valor_total
- **itens_venda:** id, venda_id, produto_id, quantidade, preco_unitario

---

## 8. Conclusão

O sistema foi instalado, testado e atende aos requisitos iniciais.  
As propostas para a segunda parte visam tornar o sistema mais flexível, escalável e amigável.

---

**Anexe prints das telas principais e do banco funcionando ao final do documento.** 