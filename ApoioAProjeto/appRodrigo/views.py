from django.shortcuts import render
from appRodrigo.models import Usuario

def index(request):
    if request.method == 'POST':
        erro_bool = False
        user_bool = False
        pass_bool = False
        username_input = request.POST.get('username')
        password_input = request.POST.get('password')
        dict_templates = dict()
        usuarios_do_banco = Usuario.objects.values_list('usuario','senha','categoria')
        for usuario_cadastrado in usuarios_do_banco:
            usuario = usuario_cadastrado[0]
            senha = usuario_cadastrado[1]
            categoria = usuario_cadastrado[2]
            if username_input == usuario:
                user_bool = True
            if password_input == senha:
                pass_bool = True
            if user_bool == True and pass_bool == True:
                erro_bool = True
                request.session['usuario'] = usuario
                request.session['categoria'] = categoria
                dict_templates = {'1':'Gerente.html','2':'Tester.html','3':'Dev.html'}
                break
        if erro_bool == True:
            return render(request, dict_templates[categoria])
        else:
            return render(request, 'index.html', {'erro': 'aa'})

    return render(request, 'index.html')
