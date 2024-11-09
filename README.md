# ProyectoInterficies
Proyecto primer trimestre

El principal problema con este proyecto ha sido gestionar tantos elementos, tanto nuevos como conocidos. 
Crear una interfaz, que es algo nuevo, con bastantes elementos y conectarlo todo con una base de datos (algo
nuevo también) y que funcione medianamente bien ha sido un desafío. 

La primera barrera fue aprender a entender los eventos y a utilizarlos correctamente. Se trata de algo que no 
habíamos visto y al principio fué difícil de captar para mi.

La segunda barrera fué la conexión con la base de datos. Supuso un salto de complejidad muy de golpe. 

Por otro lado, la capa de lógica también ha sido bastante compleja y no sé si la he llevado a cabo de la mejor forma. 
Algunos métodos no he tenido tiempo a pasarlos a esa capa, pero al menos creo que he captado el sentido que tiene usarla. 

El manejo del apartado gráfico de la interfaz ha resultado algo frustrante ya que se siente limitado y complejo. 
Cualquier cambio requiere trabajo y se hace tedioso. Posiblemente la práctica agiliza este proceso.

Como problemas más concretos, tuve dificultades para que el video empezase ya reproducéndose, ya que el programa detectaba 
que no se habían cargado los elementos y daba error. Buscando por internet y con la ayuda de chatgt utilicé 
la función invokeLater de swing utilities para hacer que el programa esperase a estar cargado antes de reproducir el vídeo.

Relacionado con lo anterior también me dió problemas la posibilidad de ordenación de las tablas y que el elemento seleccionado
djase de ser el que debería (incluyendo el vídeo). Esto lo solucioné con convertRowqIndexToModel, como vimos en clase.

Otra complicación fue habilitar y deshabilitar los botones de modificar, eliminar y guardar review según si el intnto
tenía o no ya una review hecha. El resultado final se acerca bastante a lo que buscaba, pero aún hay ciertos fallos 
que hacen que la usabilidad no sea del todo buena. 