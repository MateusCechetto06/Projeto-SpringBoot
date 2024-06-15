Projeto Spring Boot

Foi criado duas entidades chamadas Departamento e Funcionario onde elas se relacionam de muitos funcionários podem pertecem a um departamento. 

Na entidade departamento temos a coluna id e nome.
Na entidade funcionario temos a coluna id, nome, idade e o departamento.
Em ambas as entidades foram usadas as annotation @Getter, @Setter, @AllArgsConstructor, @NoArgsConstructor e @Entity. 

Em sequência, foi criado os repositorios dessas entidades, onde é ali que daremos o poder do JpaRepository a elas. Fazendo com que elas herdem todos os metodos existentes do JpaRepository.
Foi visto também a necessidade de criação de novos metodos, então foi criados alguns alem do que já foram herdados.

Depois disso, é criado os services das entidades. Onde no service terá uma instância do repository criado para poder fazer as funções desejadas. 
Nesses services ficará as funções entre a aplicação e o banco de dados, onde terá busca, atualização, inserção, remoção, entre outras.

Logo após a criação do service, temos a criação das chamadas http que ficaram dentro de um @RestController. Elas serão responsável por disponibilizar endpoints que poderão ser utilizados num postman para testes. 
Nestas controllers terão todos os metodos de busca, atualização, inserção e remoção que criamos dentro do service e os tratamentos necessários para cada tipo de requisição.
