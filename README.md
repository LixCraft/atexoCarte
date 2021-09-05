# Description of the application 

> On souhaite développer un jeu de cartes.  
> Dans ce jeu, un joueur tire une main de 10 cartes de manière aléatoire.  
> 
> Chaque carte possède une couleur ("Carreaux", par exemple) et une valeur ("10", par exemple).  
> On vous demande de:  
> Construire un ordre aléatoire des couleurs. L'ordre des couleurs est, par exemple, l'un des suivants :  
> --> Carreaux, Coeur, Pique, Trèfle  
> Construire un ordre aléatoire des valeurs. L'ordre des valeurs est, par exemple, l'un des suivants :  
> --> As, 5, 10, 8, 6, 7, 4, 2, 3, 9, Dame, Roi, Valet  
> 
> Construire une main de 10 cartes de manière aléatoire.  
> Présenter la main "non triée" à l'écran puis la main triée selon n'importe quel ordre défini dans la 1ère et 2ème étape. C'est-à-dire que vous devez classer les cartes par couleur et valeur.  
> 
> Vous présenterez une solution qui tourne sur le langage Java/Spring.  
> Vous pouvez utiliser un serveur d'application pour présenter la main de l'utilisateur (une interface graphique est la bienvenue), ou simplement la sortie console.  

# Technical stack

> Java 11
> SpringBoot 2.5.4
> JUnit 5.7.2

# Running Instruction

> Configure you IDE with JDK 11
> Run the file CartesApplication.java

> Result is observable on the console 

# Example :
-----Génération d'un ordre aléatoire des couleurs-----  
SPADE  
DIAMOND  
CLUB  
HEART  
-----Génération d'un ordre aléatoire des valeurs-----  
CardValue{value=2, label='2'}  
CardValue{value=7, label='7'}  
CardValue{value=12, label='QUEEN'}  
CardValue{value=9, label='9'}  
CardValue{value=11, label='JACK'}  
CardValue{value=4, label='4'}  
CardValue{value=6, label='6'}  
CardValue{value=10, label='10'}  
CardValue{value=8, label='8'}  
CardValue{value=1, label='AS'}  
CardValue{value=3, label='3'}  
CardValue{value=13, label='KING'}  
CardValue{value=5, label='5'}  
-----Génération aléatoire d'une main de 10 cartes -----  
Card{value=AS, color=CLUB}  
Card{value=6, color=HEART}  
Card{value=7, color=SPADE}  
Card{value=7, color=DIAMOND}  
Card{value=9, color=SPADE}  
Card{value=6, color=CLUB}  
Card{value=4, color=SPADE}  
Card{value=JACK, color=SPADE}  
Card{value=JACK, color=HEART}  
Card{value=9, color=DIAMOND}  
-----Tri de la main de 10 cartes -----  
Card{value=7, color=SPADE}  
Card{value=7, color=DIAMOND}  
Card{value=9, color=SPADE}  
Card{value=9, color=DIAMOND}  
Card{value=JACK, color=SPADE}  
Card{value=JACK, color=HEART}  
Card{value=4, color=SPADE}  
Card{value=6, color=CLUB}  
Card{value=6, color=HEART}  
Card{value=AS, color=CLUB}  

