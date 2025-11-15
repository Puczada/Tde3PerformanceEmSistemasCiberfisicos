Fluxograma onde N=5 mostrando quem pega qual garfo e por quê, usando a hierarquia(sempre o menor índice primeiro).

Definições:
- Garfos: 0, 1, 2, 3, 4.
- Filósofo p usa os garfos p e (p+1) modulo de 5.
- Regra: primeiro min(garfo_esq, garfo_dir), depois max(...).

Quem é o “primeiro” e o “segundo” de cada filósofo:
- F0: precisa de 0 e 1 → primeiro 0, depois 1
- F1: 1 e 2 → primeiro 1, depois 2
- F2: 2 e 3 → primeiro 2, depois 3
- F3: 3 e 4 → primeiro 3, depois 4
- F4: 4 e 0 → primeiro 0, depois 4  (note que F4 não começa pelo 4)

um exemplo de execução:
1:Todos ficam com fome ao mesmo tempo e tentam pegar o “primeiro”:
   - F0 pega 0; F1 pega 1; F2 pega 2; F3 pega 3.
   - F4 também tenta 0, mas 0 já está com F0 → F4 espera sem segurar nada.

2:Todos tentam o “segundo”:
   - F0 quer 1 (ocupado por F1) → espera segurando 0.
   - F1 quer 2 (ocupado por F2) → espera segurando 1.
   - F2 quer 3 (ocupado por F3) → espera segurando 2.
   - F3 quer 4 (livre) → pega 4 e começa a comer.

3:F3 termina de comer e libera 4 e 3.
   - F2 agora consegue pegar 3 → come → libera 3 e 2.
   - F1 pega 2 → come → libera 2 e 1.
   - F0 pega 1 → come → libera 1 e 0.
   - Com 0 livre, F4 pega 0; quando 4 estiver livre, pega 4 → come.

Não há deadlock, pois:
- Todos pedem do menor para o maior. Logo, ninguém pede um garfo de índice menor enquanto segura um maior.
- As esperas sempre “apontam” para índices maiores, então não pode existir um ciclo de espera.
- O caso clássico “todos pegam o da esquerda” não acontece para F4, pois ele não começa pelo 4; ele disputa o 0. Quem perder a disputa do 0 espera sem segurar nada, quebrando a formação de ciclo.
