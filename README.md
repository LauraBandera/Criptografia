# Criptografia
La criptografía se ha definido, tradicionalmente, como el ámbito de la criptología que se ocupa de las técnicas de cifrado destinadas 
a alterar las representaciones lingüísticas de ciertos mensajes con el fin de hacerlos ininteligibles a receptores no autorizados.

En esta práctica hay que hacer uso de dos técnicas básicas utilizadas en la criptografía clásica: la transposición y la sustitución. La 
transposición consiste en mover las letras de una palabra siguiendo un criterio o algoritmo, de forma que la palabra resultante tiene las 
mismas letras pero desordenadas. La sustitución es la técnica por la que se sustituyen todas o algunas letras de una palabra por otras, 
siguiendo unas reglas predefinidas.

En este caso se te pide implementar un programa que permita cifrar y descifrar una palabra teniendo en cuenta el algoritmo de cifrado que 
hay a continuación, totalmente inventado. El programa debe dar dos opciones: cifrar o descifrar. La palabra a cifrar o descifrar se lee usando 
Scanner y si contiene minúsculas, se debe pasar a mayúsculas, de forma que todas las letras sean mayúsculas antes de comenzar el algoritmo 
de cifrado o descifrado. Para mostrar el resultado se usará la consola estándar.

ALGORITMO DE CIFRADO / DESCIFRADO

Se hace la imagen especular de la palabra leída. Por ejemplo, para la palabra “AVION” su imagen especular sería “NOIVA”. En este caso se hace 
transposición de caracteres, ya que se usan las mismas letras en otro orden.
Se sustituyen las vocales según el siguiente esquema. En este caso se hace sustitución, ya que las vocales se cambian por otros caracteres diferentes:
	
A = 5
E = 4
I = 3
O = 2
U = 1

De esta forma, “NOIVA” quedaría como “N23V5”.

La palabra cifrada final resulta de añadir dos letras aleatorias, entre A y Z, justo una al principio y otra al final de la cadena obtenida en el 
paso B. Por ejemplo, nuestra cadena “N23V5” podría quedar tal que así “WN23V51”, ya que las letras aleatorias que han salido son W e U. Hay que tener 
en cuenta que si la letra aleatoria es una vocal, se aplica la transformación del apartado B. En este caso se hace sustitución y se añade aleatoriedad a 
la palabra resultante.

En cualquiera de los dos casos (cifrado/descifrado), el programa irá mostrando por consola cada una de las transformaciones que se realizan en la cadena de 
texto hasta obtener la cadena final cifrada o descifrada.
