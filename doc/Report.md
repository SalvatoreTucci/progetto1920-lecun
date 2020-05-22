# Relazione tecnica finale

## Indice

1. [Introduzione](#Introduzione)
2. [Modello di dominio](#Modello-di-dominio)
3. [Requisiti specifici](#Requisiti-specifici) <br>
a. [Requisiti funzionali](#Requisiti-funzionali) <br>
b. [Requisiti non funzionali](#Requisiti-non-funzionali)

4. [System Design](#System-Design)
    - [Stile architetturale adottato](#Stile-architetturale-adottato)
    - [Diagramma dei package](#Diagramma-dei-package)
5. [O.O. Design](#OO-Design)
    - [Diagrammi delle classi e diagrammi di sequenza](#Diagrammi-delle-classi-e-diagrammi-di-sequenza) <br>(per le user story considerate più importanti)
    - [Design pattern utilizzati](#Design-pattern)
    - [Commenti](#Commenti)
6. [Riepilogo dei test](#Riepilogo-dei-test)
    - [Tabella riassuntiva di coveralls](#Tabella-riassuntiva)
7. [Manuale utente](#Manuale-utente)
8. [Processo di sviluppo e organizzazione del lavoro](#Processo-di-sviluppo-e-organizzazione-del-lavoro)
9. [Analisi retrospettiva](#Analisi-retrospettiva)
    - [Soddisfazioni](#Soddisfazioni)
    - [Insoddisfazioni](#Insoddisfazioni)
    - [Cosa ci ha fatti impazzire](#Cosa-ci-ha-fatti-impazzire)

# Introduzione
Scacchi-LeCun è un' applicazione per il gioco degli scacchi con interfaccia a linea di comando.
Il gioco accetta comandi in notazione algebrica italiana abbreviata e permette a due giocatori
di sfidarsi localmente. <br>
L'esecuzione avviene a linea di comando via [Docker](https://hub.docker.com/).
Il progetto è stato realizzato durante il corso di Ingegneria del Software dal gruppo LeCun
(a.a. 2019/2020), i cui membri sono:
- [Giuseppe Lamantea](https://github.com/llamandtea)
- [Raffaele Disabato](https://github.com/Raffo99)
- [Giovanni Pio Delvecchio](https://github.com/GiovanniPioDelvecchio)
- [Domenico Dell'Olio](https://github.com/DomMcOyle) <br><br>


[Torna all'indice](#Indice)

# Modello di dominio
<center><img src = "./drawings/modello_dominio.png" alt = "modello di dominio"></center>

 <br><br>

[Torna all'indice](#Indice)

# Requisiti Specifici

Di seguito sono riportati i requisiti funzionali (in ordine cronologico rispetto alla creazione degli issue corrispondenti) seguiti dai requisiti non funzionali.


## Requisiti funzionali 

- [Inizio gioco](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/25)

    L'utente può predisporre l'applicazione a ricevere i comandi, tramite <code>play</code>.
    Subito dopo sarà dunque possibile inserire la prima mossa di gioco (del bianco). 
    L'applicazione può anche ricevere altri comandi (di gioco) ad esempio <code>board</code> (per mostrare la scacchiera).

    <b>Criteri di accettazione:</b>

    All'immisione del comando <code>play</code> viene visualizzato il messaggio di inizio gioco: 
    <code>Nuova Partita! Inizia il bianco:</code>
    ed il programma si predisone a mostrare un comando o una mossa valida.
    Nel caso in cui l' utente scriva <code>play</code> mentre una partita è in corso viene stampato un messaggio di conferma. Se l'utente conferma comincia una nuova partita,
    in caso contrario rimane accessibile quella corrente.

- [Chiudere il gioco](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/26)

    L'utente può terminare l'applicazione tramite il comando <code>quit</code>.

    <b>Criteri di accettazione:</b>

    All' immissione del comando <code>quit</code> viene visualizzato un messaggio che chiede conferma
    all'utente sulla chiusura del comando. Nel caso in cui l'utente risponda in modo affermativo, l'utente torna ad interagire con il sistema operativo. Se la risposta è negativa, continua ad interagire con l'applicazione.



- [Comando help](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/27)

    L'utente può visualizzare l'elenco dei comandi disponibili tramite il comando <code>help</code>. 
    
     <b>Criteri di accettazione:</b>
    
    Eseguendo il comando <code>help
    </code>, il risultato è una lista di comandi, uno per riga, ovvero: <br>
    
    <code>help  </code> <br>
    <code>play </code><br>
   <code> quit </code><br>
   <code> Riconosciuti solo in-game: </code><br>
   <code> moves </code><br>
    <code>board </code><br>
    <code>capture </code><br>
    

- [Mostrare scacchiera](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/28)

    L'utente può mostrare a schermo la scacchiera tramite il comando <code>board</code>.
    
     <b>Criteri di accettazione:</b>
     
     
     il formato della scacchiera deve essere quello presente in <code>[Assegnazione progetto.md](../Assegnazione%20progetto.md)</code>. Tutti i pezzi sono rappresentati nel contesto della tastiera in UTF-8 con i caratteri specifici (es. ♔ e ♚ per re bianco e nero).
     <center><img src ="./drawings/nonuml/Scacchiera.png" width = 450></center>

- [Mostrare le mosse giocate](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/29)

    L'utente può visualizzare le mosse giocate (quindi riconosciute ed attuate dal programma)
    tramite il comando <code>moves</code>.

     <b>Criteri di accettazione:</b>

    Tramite il comando <code>moves</code> viene stampata la successione di mosse effettuate nel corso della partita, in notazione algebrica abbreviata, secondo la sintassi:
   
    <code>1. e4 e5</code> <br> 
    <code>2. Cf3 Cc6 </code>  <br>
    <code>3. d4 </code>  <br>
    

    Come mostrato nel file <code>[Assegnazione progetto.md](../Assegnazione%20progetto.md)</code>.

- [Muovere un Pedone](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/30)

    L'utente può muovere un pedone inserendo il comando in notazione algebrica abbreviata,
    rispettando le regole degli scacchi. 
    
     <b>Criteri di accettazione:</b>

    Con il pedone l'utente può:
    - muoversi in una sola direzione (a seconda del colore);
    - catturare normalmente ed en passant (per quest' ultimo caso è possibile aggiungere 
    e.p. nel comando, in conformità con la notazione).

    All'immissione di una mossa valida come:
    - e4
    - f5
    - exf5

    il programma aggiorna lo stato della scacchiera, altrimenti viene visualizzato un messaggio di errore e
    l'applicazione rimane in attesa di un nuovo comando.

    Sono anche valide le catture en passant:
    - exf6
    - exf6 e.p.


- [Visualizzare le catture](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/31)

    L'utente deve poter visualizzare le catture effettuate durante la partita tramite il comando <code>capture</code>.
    
     <b>Criteri di accettazione:</b>

    con il comando <code>capture</code> vengono stampate le catture sia del bianco che del nero, attraverso i relativi caratteri nella codifica Unicode, nel seguente modo:
    
    <code> [♟, ♟, ♟] </code> <br>
    <code> [♗, ♕, ♘, ♖] </code> <br>
    

- [Muovere un Cavallo](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/101)

    L'utente può muovere un cavallo inserendo il comando in notazione algebrica abbreviata, rispettando le regole degli scacchi. 
    
     <b>Criteri di accettazione:</b>

    Con il cavallo l'utente può:
    - muoversi e catturare alternativamente su case bianche e case nere. Il movimento di questo pezzo può essere descritto come due passi in orizzontale (verticale) seguito da un passo in verticale (orizzontale).
    Questo movimento forma idealmente una "L";
    - ignorare i pezzi lungo il suo percorso (tranne quello che si trova sulla casa di arrivo);

    All'immissione di una mossa valida come:
    - Cc3
    - Cxd3

    il programma aggiorna lo stato della scacchiera, altrimenti viene visualizzato un messaggio di errore e
    l'applicazione rimane in attesa di un nuovo comando.

- [Muovere un Alfiere](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/102)

    L'utente può muovere un alfiere inserendo il comando in notazione algebrica abbreviata, rispettando
    le regole degli scacchi. 
    
     <b>Criteri di accettazione:</b>

    Con l'alfiere l'utente può:
    - muoversi e catturare sulle case che si trovano lungo le diagonali (rispetto all'alfiere stesso),
    ammesso che le case siano libere.
    - non può spostarsi su una casa di un colore differente rispetto al colore di quella su cui si trova.

    All'immissione di una mossa valida come:
    - Ac4
    - Axa6

    il programma aggiorna lo stato della scacchiera, altrimenti viene visualizzato un messaggio di errore e
    l'applicazione rimane in attesa di un nuovo comando.

- [Muovere una Torre](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/103)

    L'utente può muovere una torre inserendo il comando in notazione algebrica abbreviata, rispettando
    le regole degli scacchi. 
    
     <b>Criteri di accettazione:</b>

    Con la torre l'utente può:
    - muoversi e catturare orizzontalmente e verticalmente (rispetto alla torre stessa), ammesso che le case siano libere;

    All'immissione di una mossa valida come:
    - Ta5
    - Txd4

    il programma aggiorna lo stato della scacchiera, altrimenti viene visualizzato un messaggio di errore e
    l'applicazione rimane in attesa di un nuovo comando.

- [Muovere una Donna](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/104)

    L'utente può muovere una donna inserendo il comando in notazione algebrica abbreviata, rispettando le regole degli scacchi. 
    
     <b>Criteri di accettazione:</b>

    Con la donna l'utente può:
    - muoversi e catturare orizzontalmente e verticalmente ed in diagonale (rispetto alla donna stessa),
    ammesso che le case siano libere.

    All'immissione di una mossa valida come:
    - Dd4
    - Dxf5

    il programma aggiorna lo stato della scacchiera, altrimenti viene visualizzato un messaggio di errore e
    l'applicazione rimane in attesa di un nuovo comando.

- [Muovere un Re](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/107)

    L'utente può muovere un re inserendo il comando in notazione algebrica abbreviata, rispettando le regole degli scacchi. 
    
     <b>Criteri di accettazione:</b>

    Con il re l'utente può:
    - muoversi in tutte le direzioni di una sola casella (rispetto a quella di partenza), ammesso che non sia ostruita;
    - non può muoversi in case minacciate da pezzi avversari (non deve mai rischiare la cattura);

    All'immissione di una mossa valida come:
    - Re2
    - Rxd2

    il programma aggiorna lo stato della scacchiera, altrimenti viene visualizzato un messaggio di errore e
    l'applicazione rimane in attesa di un nuovo comando.
    
- [Arroccare corto](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/115)

    L'utente può effettuare l' arrocco corto inserendo il comando in notazione algebrica abbreviata, rispettando le regole degli scacchi. 

     <b>Criteri di accettazione:</b>

    Al fine della corretta esecuzione dell' arrocco è necessario che lo stato del gioco rispetti i seguenti requisiti:

    - il giocatore non ha mai mosso il re;
    - il giocatore non ha mai mosso la torre coinvolta nell'arrocco;
    - non ci sono pezzi tra il re e la torre coinvolta;
    - il re e la torre devono trovarsi sulla stessa traversa (questa regola venne introdotta nel 1972 quando si scoprì che le regole altrimenti permettevano l'arrocco in verticale con un pedone promosso a torre); 
    - il re non deve essere sotto scacco;
    - il re, durante il movimento dell'arrocco, non deve attraversare caselle in cui si troverebbe sotto scacco.

    All'immissione delle mosse valide per l'arrocco: 
    - 0-0
    - O-O

    il programma aggiorna lo stato della scacchiera, altrimenti viene visualizzato un messaggio di errore e
    l'applicazione rimane in attesa di un nuovo comando.


- [Arroccare lungo](https://github.com/softeng1920-inf-uniba/progetto1920-lecun/issues/116)

    L'utente può effettuare l' arrocco lungo inserendo il comando in notazione algebrica abbreviata, rispettando le regole degli scacchi. 

    <b>Criteri di accettazione:</b>

    Al fine della corretta esecuzione dell' arrocco è necessario che lo stato del gioco rispetti i seguenti requisiti:

    - il giocatore non ha mai mosso il re;
    - il giocatore non ha mai mosso la torre coinvolta nell'arrocco;
    - non ci sono pezzi tra il re e la torre coinvolta;
    - il re e la torre devono trovarsi sulla stessa traversa (questa regola venne introdotta nel 1972 quando si scoprì che le regole altrimenti permettevano l'arrocco in verticale con un pedone promosso a torre); 
    - il re non deve essere sotto scacco;
    - il re, durante il movimento dell'arrocco, non deve attraversare caselle in cui si troverebbe sotto scacco.

    All'immissione delle mosse valide per l'arrocco:
    - 0-0-0
    - O-O-O

    il programma aggiorna lo stato della scacchiera, altrimenti viene visualizzato un messaggio di errore e
    l'applicazione rimane in attesa di un nuovo comando.

 <br><br>

[Torna all'indice](#Indice)

## Requisiti non funzionali 

- ### Portabilità
    L'applicazione è disponibile per le seguenti piattaforme:
    - terminale di Linux;
    - teminale di MacOS;
    - Windows Terminal;
    - Git Bash  (in questo caso il comando Docker ha come prefisso winpty; es:  
    <code>winpty docker -it ...</code>)

- ### Affidabilità
    L'applicazione è progettata per evitare eccezioni non gestite, le eccezioni vengono cattuarate
    e gestite, inoltre per ogni situazione non valida è stampato un messaggio.

- ### Manutenibilità

    Il codice è stato suddiviso in diverse sottoclassi: 
    - la presenza di una classe UI separa il comportamento effettivo del gioco dall'interfaccia,
    rendendo possibile modificare la logica di business da quella di visualizzazione;
    - è stata creata una classe contenente tutte le costanti, che potrebbe essere successivamente 
    sostituita da un file;


 <br><br>

[Torna all'indice](#Indice)

# System Design

## Stile architetturale adottato
E' stato adottato lo stile architetturale Model-View-Controller, per via della caratteristica, presentata anche fra i requisiti non funzionali, di separare la logica di business dalla presentazione. 

I tre componenti che implementano questa architettura sono:

- <b>Model</b>

    La logica di business è concentrata quasi del tutto all'interno della classe <code>Match</code>. <br>
    Essa espone, infatti, i metodi necessari per modellare il comportamento di una partita a scacchi, gestendo le strutture dati utilizzate per rappresentare la scacchiera, aggiornandole in base all'input (ammesso che siano stati inseriti comandi corretti)
    proveniente da UI (controller). <br>
    La classe <code>Match</code> non interagisce mai con l'interfaccia CLI su cui sono stampati i messaggi.

- <b>View</b> 

    E' possibile visualizzare i risultati delle elaborazioni tramite l'interfaccia CLI (Command Line Interface) adottata per realizzare questo progetto.<br>
    Tutto ciò che viene mostrato su tale interfaccia è stampato tramite la classe <code>UI</code>, dunque l'interfaccia CLI non interagisce mai con la classe <code>Match</code> se non attraverso <code>UI</code>.


- <b>Controller</b>

    L'interazione con l'utente avviene tramite la classe <code>UI</code> che chiede direttamente le conferme all'utente, ma riceve dalla classe AppMain la stringa corrispondente al comando inserito. <br>
    A <code>UI</code> sono demandati i compiti di acquisizione dei comandi e stampa a video (sulla CLI) dei messaggi corrispondenti ad ogni comando. <br>
    <code>Match</code> lancia messaggi di errore e modifica le strutture dati, tuttavia non interagisce mai direttamente con l'interfaccia Command Line, poiché è <code>UI</code> a catturare le <code>MatchException</code> lanciate e stampare i relativi messaggi, ed è sempre <code>UI</code> a stampare scacchiera, mosse effettuate, pezzi catturati ed help.


## Diagramma dei package

<center><img src = "./drawings/diagramma_package.png"></center>

 <br><br>

[Torna all'indice](#Indice)

# O.O. Design

## Diagrammi delle classi e diagrammi di sequenza

### Diagramma delle classi con prospettiva software completo
<center><img src = "./drawings/diagramma_classi_prospettiva_software.png"></center>

### Diagramma delle classi con prospettiva software per la user story "Muovere una torre"
<center><img src = "./drawings/diagramma_classi_prospettiva_software_mossa.png"></center>

### Diagramma di sequenza per la user story "Muovere una torre"
<center><img src = "./drawings/diagramma_sequenza_movimento_torre.png"></center>

### Diagramma di sequenza per la user story "Inizio gioco"
<center><img src = "./drawings/diagramma_inizio_gioco.png"></center>

### Diagramma di sequenza per la user story "Mostrare scacchiera"
<center><img src = "./drawings/diagramma_sequenza_comando_board.png"></center>

 <br><br>

[Torna all'indice](#Indice)

## Design pattern



## Commenti

 <br><br>

[Torna all'indice](#Indice)

# Riepilogo dei test
## Tabella riassuntiva

 <br><br>

[Torna all'indice](#Indice)

# Manuale utente

 <br><br>

[Torna all'indice](#Indice)

# Processo di sviluppo e organizzazione del lavoro

 <br><br>

[Torna all'indice](#Indice)

# Analisi retrospettiva
## Soddisfazioni
## Insoddisfazioni
## Cosa ci ha fatti impazzire

 <br><br>

[Torna all'indice](#Indice)
