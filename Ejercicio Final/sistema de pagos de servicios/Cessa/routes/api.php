<?php

use App\Http\Controllers\FacturaController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::get('/facturas/{id}', [FacturaController::class, 'showByCi']);
Route::put('/facturas/{id}', [FacturaController::class, 'pagarFactura']);

Route::post('/facturas', [FacturaController::class, 'store']);
