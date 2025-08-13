Projeto Sudoku para o Bootcamp DIO


@Author: Marllon Vieira Vergili

MEU GITHUB: https://github.com/Marllon-Vieira-Vergili
MEU LINKEDIN: https://www.linkedin.com/in/marllon-vieira-vergili-00553a208/


Este projeto, é a criação de um jogo
SUDOKU em java.

Peguei a base de referência seguindo as video-aulas do 
curso da DIO, mas realizando minhas modificações.


A versão que estarei utilizando é a JDK 21 com
Intellij.

---------------------COMO DEVE FUNCIONAR A LÓGICA DO SUDOKU------------------

conforme li, e analisei pelo wikipedia, este jogo é inserir números de 1 a 9 em cada 
célula vazia, em uma grade de 9x9 constituída de grades de 3x3. Ou Seja..
preciso criar um array total de 9x9 posições, e arrays menores com posição 3x3. 
Essas subgrades, são chamadas regiões(Vou utilizar isso como parâmetro para variáveis).

O quebra cabeça contém algumas pistas iniciais (pelo que entendi, pode ser feito utilizando
classe random para gerar valores aleatórios em cada parte de cada bloco no array), de maneira
a permitir uma indução ou deduçõ dos números em células que estejam vazias. (Pelo que entendi, 
podemos criar um método para deduzir isso). Cada coluna, linha e região só poed ter um númeo decada 
um dos 1 a 9 (Cada coluna não pode repetir o mesmo número, pelo que eu entendi).

Com base no que eu li na introdução do wikipedia sobre sudoku, ja posso imaginar
como eu poderia montar esse algoritmo.