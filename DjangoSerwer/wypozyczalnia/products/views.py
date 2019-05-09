from django.shortcuts import render
from django.http import HttpResponse
from .models import Products
from django.http import JsonResponse
from django.core import serializers
import json
from .forms import ProductForm

def show(request):
	product = serializers.serialize("json",  Products.objects.all(), fields=('category','name'))
	productD = json.loads(product)

	print(productD[0]['fields'])
	products =[]
	for i in productD:
		products.append(i['fields'])

	print(products)
	return JsonResponse(products,safe=False)

def addProduct(request):
	form = ProductForm(request.GET or None)
	if form.is_valid():
		form.save()
		

	context = {
		'form':form 
	}

	return render(request, "product_create.html", context)

