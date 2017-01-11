# Walmart
Entregando mercadorias

Um e-commerce está desenvolvendo um novo sistema de logística e sua ajuda é muito importante neste

momento. Sua tarefa será desenvolver o novo sistema de entregas visando sempre o menor custo. Para popular

sua base de dados o sistema precisa expor um Webservice que aceite o formato de malha logística (exemplo

abaixo), nesta mesma requisição o requisitante deverá informar um nome para este mapa. É importante que os

mapas sejam persistidos para evitar que a cada novo deploy todas as informações desapareçam.

O formato de malha logística é bastante simples, cada linha mostra uma rota: ponto de origem, ponto de

destino e distância entre os pontos em quilômetros.

A B 10

B D 15

A C 20

C D 30

B E 50

D E 30

Com os mapas carregados o requisitante irá procurar o menor valor de entrega e seu caminho, para isso

ele passará o mapa, nome do ponto de origem, nome do ponto de destino, autonomia do caminhão (km/l) e o

valor do litro do combustível, agora sua tarefa é criar este Webservice.

Um exemplo de entrada seria: Mapa SP, origem A, destino D, autonomia 10, valor do litro 2,50; a resposta

seria a rota A B D com custo de 6,25.

## Sobre o Desenvolvimento
----------
Foi utilizado o Android Studio para o desenvolvimento do aplicativo.
O projeto foi desenvolvido com MVP dessa forma temos as views totalmente desacoplada dos processamentos, facilitando nos testes unitários.

Bibliotecas Utilizadas
----------
- [x] https://github.com/wtw-software/DijkstraLib (realizei algumas customizações para se adaptar ao código).
- [x] http://jakewharton.github.io/butterknife/ (para injeção de dependencia)
- [x] https://realm.io/docs/java/latest/ (para persistência de dados no aparelho):

## Usage
Na pasta do projeto existe um arquivo chamado walmart.apk, faça download desse arquivo e coloque no seu aparelho android.
A versão mínima suportada pelo projeto é SDK 17 Android 4.2.
Execute o aplicativo e então já conseguirá efetuar os testes.

Para alteração dos dados de teste é necessário alterar o arquivo map.json que está localizado (Walmart/Walmart/app/src/main/res/raw).Após alterar esse arquivo é necessário compilar o projeto novamente utilizando o Android Studio.
