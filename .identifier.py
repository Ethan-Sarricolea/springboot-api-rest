import os

def listar_directorio(ruta=".", nivel=0):
    for item in sorted(os.listdir(ruta)):
        if item.startswith('.'): continue # Oculta archivos ocultos si quieres
        ruta_completa = os.path.join(ruta, item)
        prefijo = "  " * nivel
        if os.path.isdir(ruta_completa):
            print(f"{prefijo}- {item}/")
            listar_directorio(ruta_completa, nivel + 1)
        else:
            print(f"{prefijo}- {item}")

listar_directorio()
