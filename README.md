DIA 1

Chegou a hora, Joel! Você vai começar a sua jornada no #7DaysOfCode ;)

Este primeiro dia é super importante! Ao final dele, você terá um novo conhecimento que é essencial para os próximos desafios.

Muita gente na nossa área de tecnologia é fanática por cinema, séries e filmes. Por isso mesmo, o tema geral do nosso desafio vai ter tudo a ver com isso.

Você conhece o IMDB? É provavelmente a plataforma mais famosa que agrupa basicamente todos os filmes, séries, programas de TV, atores, etc., do mundo. Você pode imaginar que o banco de dados deles deve ser colossal!

No desafio de hoje, você vai fazer o seu código Java rodar e consumir a API do IMDB! Seu objetivo será imprimir os resultados de uma busca na linha de comando.

Explicando melhor, você vai usar essa API para pesquisar os top 250 filmes e imprimir o JSON correspondente no console da sua IDE.

Para isso, você pode acessar o webservice ou API da plataforma em:

https://imdb-api.com/api

O site do IMDB tem uma documentação bem legal para você se familiarizar com os parâmetros da chamada e analisar o retorno.

Ahh, também será preciso gerar uma APIKey (uma chave de acesso), registrando o seu email no site. Com a chave em mãos, você poderá buscar filmes, séries, etc., através da API.

Por exemplo, para buscar o nome de um filme, basta usar:

https://imdb-api.com/en/API/Top250Movies/<apiKey>https://imdb-api.com/en/API/Top250Movies/

O resultado da pesquisa será um JSON parecido com esse:

{"items":[{"id":"tt5491994","rank":"1","title":"Planet Earth II","fullTitle":"Planet Earth II (2016)"…

Mas chegou a hora de escrever o código e fazer a coisa funcionar! Vamos lá? Vou passar aqui abaixo uma espécie de passo-a-passo, para você não se perder muito neste primeiro dia. O que você vai precisar fazer:

Criar uma conta no IMDB para ter a chave de acesso ao serviço (apiKey), mas cuidado, essa chave não deve ser commitada no Github ou em outro repositório!

Criar o código Java que executará uma requisição HTTP do tipo GET. Você pode usar o pacote java.net.http e as classes HttpRequest, HttpClient e HttpResponse, além da classe URI

Executar a requisição e pegar a resposta (o JSON)

Imprimir o corpo da resposta no console

Simples, não? Nesse exercício, eu sugeri usar as classes do pacote java.net.http, mas você pode escolher qualquer outra. Se quiser, você pode inclusive usar outros conectores HTTP.

Para esse início, faça tudo no main mesmo! Posteriormente, vou te guiar na evolução desse código, para que ele seja mais maleável, orientado a objetos, e para te gerar algumas reflexões também.

DICA
Tanto a classe java.net.http.HttpRequest quanto a java.net.http.HttpClient seguem o padrão de projeto Builder para simplificar a construção de um objeto dessas classes. Isso significa que você não vai usar ‘new’ diretamente, mas sim métodos auxiliares para deixar a construção mais expressiva e fluída.

Por exemplo, para construir um objeto da classe HttpRequest, você deve primeiro criar um Builder usando o método newBuilder:

   HttpRequest request = HttpRequest
            .newBuilder()
            .uri(new URI("http://www.imdb..."))
            .GET()
            .build();

Repare que, a partir do Builder, você pode definiar a URI e o tipo de requisição (GET ou POST), para depois construir o objeto com o método build().

A HttpClient funciona de maneira análoga. Ela possui o seu próprio builder, além de executar a requisição e devolver a resposta.
EXTRA
Se você quiser ver mais alguns exemplos de uso da HttpClient, você pode acessar este link.
Ah, e não se esqueça de compartilhar o seu código no seu GitHub e marcar a gente nas suas redes sociais com a hashtag #7DaysOfCode, e também com #feedback7DoC caso você queira alguma ajuda.

Bom trabalho!

Paulo Silveira
CEO e fundador da Alura

DIA 2

E aí, Joel, conseguiu desenvolver o desafio do primeiro dia e já está tudo pronto para o próximo?

Só pra garantir, vou deixar durante esses primeiros 2 dias a minha resolução lá no final deste e-mail, beleza? Assim você pode comparar com a sua, mas não esqueça de compartilhar comigo as suas resoluções, quero ver também!
Hoje é o segundo dia do seu desafio #7DaysOfCode com Java, bora praticar?

No primeiro dia, você fez uma chamada para a API do IMDB para receber o JSON dos top 250 filmes como resposta. Você deve ter recebido algo como:

{"items":[
{"id":"tt5491994","rank":"1","title":"Planet Earth II","fullTitle":"Planet Earth II (2016)","year":"2016","image":"....", …},
{"id":"tt0903747","rank":"2","title":"Breaking Bad","fullTitle":"Breaking Bad (2008)","year":"2008","image":"...."...},
….
],"errorMessage":""}

A sua tarefa de hoje será parsear essa resposta. Em outras palavras, você vai extrair as informações desse JSON. Repare que o JSON possui um array de filmes, e cada filme possui vários atributos como id, título, etc.

Trabalhar com dados em JSON é algo muito comum no dia a dia para uma pessoa desenvolvedora Java e, por isso, existem várias bibliotecas para tal. Essas bibliotecas abstraem todos os detalhes, como ler e extrair informações.

No entanto, nesse desafio, a ideia é praticar os fundamentos do Java! Ou seja, trabalhar com as principais bibliotecas incluídas no JRE, como a classe String e as famosas Expressões Regulares.

Sua tarefa será extrair o título do filme e a URL da imagem a partir da resposta JSON.

Existem várias maneiras de fazer isso e, neste momento, não se preocupe ainda em escrever um código elegante. Tente usar os métodos da classe java.lang.String como substring(), split() e replace(). Você também pode usar Regex (através das classes Matcher e Pattern do pacote java.util.regex) para encontrar uma string que siga um determinado padrão.

Com o resultado do parseamento, você deverá criar diferentes listas, cada uma com um atributo do filme. Uma lista com os títulos, outra com a URL da imagem e assim por diante. Exemplo:

    List<String> titles = //parseia o título de cada filme do JSON;

    List<String> urlImages = //parseia a URL do pôster de cada filme do JSON;

    // outras listas, com os anos (year) e as notas (imDbRating)
DICA
Não se assuste e vá por partes, dividindo a tarefa maior em sub-tarefas que possam ser implementadas através de métodos. 
Por exemplo, você pode primeiro extrair o JSON inteiro dos filmes, ou seja, buscar na resposta JSON tudo o que estiver dentro dos colchetes ("[" , "]") e guardar esse JSON.

Com ele em mãos, você pode usar o método split() para separar cada filme:

Posição 1: {"id":"tt5491994","rank":"1","title":"Planet Earth II",, ….. ,"image":"http …."}
Posição 2: {"id":"tt0903747","rank":"2","title":"Breaking Bad", …, "image":"http …"}

Agora, com esse array disponível, você pode tratar cada filme separadamente para extrair os atributos que você quiser. Basta fazer a quebra do JSON de cada filme nas vírgulas para ter acesso aos atributos:

String [] atributos = jsonFilmes.split("\","\");

E a partir daí, "só" vai faltar pegar o atributo na posição correta usando métodos da classe String e guardá-lo em uma lista. Como resultado final, você deverá ter no seu método main algo como:

public static void main(String[] args) throws Exception {

String json = //chamada da API omitida
String[] moviesArray = parseJsonMovies(json);

List<String> titles = parseTitles(moviesArray);
titles.forEach(System.out::println);

List<String> urlImages = parseUrlImages(moviesArray);
urlImages.forEach(System.out::println);

//outras listas para rating e years
}
EXTRA
Como esse trabalho é bem de baixo nível, existem as famosas bibliotecas de Binding que possibilitam ler ou criar um JSON ou XML a partir do código Java sem ter que trabalhar com Regex e métodos da classe String.

Para trabalhar com JSON temos duas bibliotecas famosas:

Jackson
GSON

Fique à vontade para praticar com alguma dessas bibliotecas.
RESPOSTA DO DESAFIO DO DIA 1
- Solução do Dia 1
  Lembre-se de compartilhar o seu código no seu GitHub e nas suas redes sociais com a hashtag #7DaysOfCode, e também com #feedback7DoC caso você queira alguma ajuda.

Bons estudos, até amanhã!

Paulo Silveira
CEO e fundador da Alura

Dia 3

Olá Joel, tudo bem? Fico muito feliz que você esteja aqui para mais um dia de desafios!

O desafio de ontem foi mais trabalhoso, mas como prometido, hoje também vou colocar a minha solução lá no final deste e-mail para você comparar com a sua.
Você já chegou no terceiro dia do #7DaysOfCode com Java!

Recapitulando, no primeiro dia você fez uma chamada à API do IMDB para buscar um JSON com os top 250 filmes. 
No segundo dia, você extraiu algumas informações desse JSON, como o título dos filmes e a URL dos pôsteres.

Como resultado, você provavelmente obteve algumas listas no seu código para guardar esses atributos, algo como:

//chamada da API omitida

List<String> titles = parseTitles(moviesArray);
titles.forEach(System.out::println);

List<String> urlImages = parseUrlImages(moviesArray);
urlImages.forEach(System.out::println);

//outras listas para anos e notas

No desafio de hoje, a ideia será modelar, ou pelo menos iniciar uma modelagem melhor do seu código.

Pensando um pouco sobre Orientação a Objetos, uma pergunta simples pode ajudar: no caso do seu projeto, 
o título e o pôster se referem a que tipo de objeto? A um filme, claro. Mas você ainda não tem nenhuma estrutura 
que defina o que é um filme.

Qual vai ser a cara disso? Um filme (Movie) deve ter os seguintes atributos:

título (title)
URL da imagem do pôster (urlImage)
nota (rating)
ano (year)

Em outras palavras, em vez de ter várias listas diferentes, uma para cada atributo do filme, 
é bem melhor organizar isso em uma única List<Movie>, onde cada filme encapsula os seus próprios dados. 
Bora implementar essa classe?

DICA
Algumas reflexões: você acha que faz sentido ter setters ou um construtor padrão? Um filme deve ser interfaceado? 
Deve ser imutável? Justifique a sua decisão no seu repositório.

EXTRA
Para quem usa uma versão mais recente do Java, faz sentido usar Records aqui?

RESPOSTA DO DESAFIO DO DIA 2
- Solução do Dia 2
  Não se esqueça de compartilhar o seu código no seu GitHub e nas suas redes sociais com a hashtag #7DaysOfCode, e também com #feedback7DoC caso você queira alguma ajuda.

Bons estudos e até amanhã!

Paulo Silveira
CEO e fundador da Alura

Dia 4

Olá, Joel.

Você chegou em mais um dia de #7DaysOfCode!

Até agora, você praticou o consumo de dados de uma API. Isto é, exercitou a maneira de receber os dados JSON de uma 
chamada HTTP e parseá-los, a fim de transformá-los em objetos.

No desafio de hoje, você vai trabalhar com a saída e gerar uma página HTML a partir da lista de objetos que você já tem 
no seu código Java.

A ideia será criar uma página HTML onde você possa ver as informações sobre o filme, incluindo o pôster, algo como:

Para tal, vou dar um pequeno passo-a-passo para te auxiliar:

Crie uma nova classe HTMLGenerator, que irá receber no construtor um Writer (por exemplo, PrintWriter)

Adicione um método chamado ‘generate’, que irá receber uma List<Movie>. Nesse método, gere todo o HTML a partir da 
lista, usando as informações do objeto. Você pode usar métodos privados para delegar responsabilidades.
(Obs: Você deve criar e fechar o Writer no método main)

Nesse momento, você pode estar se perguntando se é uma boa prática gerar um HTML dentro de uma classe Java. 
Realmente não é, pois existem bibliotecas de mais alto nível que simplificam isso, mas para este desafio de Java e a 
fim de praticar alguns conceitos sobre Orientação a Objetos, podemos fazer uma exceção!
DICA
Use os Text Blocks do Java para definir o HTML. Assim, o seu código ficará um pouco mais elegante. Por exemplo:

String head =
"""
<head>
<meta charset="utf-8">
</head>
""";

EXTRA
Aplique um CSS usando uma das bibliotecas do mercado, como a Bootstrap. Você pode usar, por exemplo, o componente Card.

Para importar o Bootstrap você pode copiar este código Java que já deixei preparado.

E também posso te fornecer o div para criar um card com Bootstrap com as informações do filme.
Claro, como sempre, não esqueça de compartilhar o seu código no seu GitHub e nas suas redes sociais com a 
hashtag #7DaysOfCode, e também com #feedback7DoC caso você queira alguma ajuda.

Bons estudos e até amanhã!

Paulo Silveira
CEO e fundador da Alura