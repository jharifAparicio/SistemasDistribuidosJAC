#iniciar el trabajador(worker)
#tabjador 1
php worker.php
#trabajador 2
php worker.php

# iniciar el productor
php new_task.php primera_tarea... # 3 segundos
php new_task.php segunda_tarea.... # 4 segundos
php new_task.php tercera_tarea..... # 5 segundos
php new_task.php cuarta_tarea...... # 6 segundos
php new_task.php quinta_tarea....... # 7 segundos
php new_task.php sexta_tarea........ # 8 segundos

# las tareas se ejecutan en el orden en que se reciben
# el tiempo de espera es el tiempo que tarda en ejecutarse la tarea para tomar otra tarea