Relatório — Problema do Jantar dos Filósofos e Deadlock

 
 1. Dinâmica do Problema
 
 
 O Jantar dos Filósofos representa um cenário clássico de concorrência composto por cinco
 filósofos sentados em uma mesa circular. Cada filósofo alterna entre dois estados: pensando e
 comendo. Para comer, um filósofo precisa adquirir dois garfos: o da esquerda e o da direita. Esses
 garfos são recursos compartilhados pelos filósofos vizinhos, exigindo exclusão mútua. O modelo
 demonstra problemas como exclusão mútua, impasse e inanição em sistemas concorrentes.
 
 
 2. Por que o impasse surge no protocolo ingênuo
 

 No protocolo ingênuo, cada filósofo tenta primeiro pegar o garfo à esquerda e depois o garfo à
 direita. Se o garfo da direita estiver ocupado, ele espera segurando o garfo da esquerda. Quando
 todos os filósofos ficam com fome simultaneamente, cada um segura seu garfo da esquerda e
 espera pelo garfo da direita, que está nas mãos do vizinho. Forma-se um ciclo de espera onde
 ninguém pode progredir, levando ao deadlock.
 

 3. Análise segundo as condições de Coffman
 

 O deadlock ocorre porque o protocolo ingênuo satisfaz todas as condições de Coffman:
 

1 - Exclusão mútua – garfos não podem ser usados por mais de um filósofo.

2 - Manter-e-esperar – cada filósofo mantém um recurso e espera por outro.

3 - Não preempção – recursos não podem ser tomados à força.

4 - Espera circular – existe um ciclo fechado de dependência entre os filósofos.
 
 
 4. Condição negada na solução proposta
 
 
 Para evitar o deadlock, utiliza-se uma hierarquia de recursos. Os garfos recebem uma ordem
 global e cada filósofo adquire primeiro o garfo de menor índice e depois o de maior índice. Essa
 estratégia elimina a espera circular, impedindo a formação de ciclos de dependência. Ao quebrar
 essa condição, o deadlock deixa de ser possível.
 
 
 Conclusão
 
 
 O problema demonstra como políticas de aquisição de recursos influenciam diretamente a
 ocorrência de deadlock. O protocolo ingênuo leva ao impasse por satisfazer todas as condições de
 Coffman. A solução com hierarquia de recursos remove a espera circular e impede o deadlock.
