<?php

namespace App\Http\Controllers;

use App\Models\Factura;
use Illuminate\Http\Request;

class FacturaController extends Controller
{
    // GET /facturas/{id} → Buscar facturas por CI del cliente
    public function showByCi($id)
    {
        $facturas = Factura::where('CI', $id)->get();

        if ($facturas->isEmpty()) {
            return response()->json(['mensaje' => 'No se encontraron facturas para este CI'], 404);
        }

        return response()->json($facturas);
    }

    // PUT /facturas/{id} → Pagar una factura por su nro_factura
    public function pagarFactura($id)
    {
        $factura = Factura::where('nroFactura', $id)->first();

        if (!$factura) {
            return response()->json(['mensaje' => 'Factura no encontrada'], 404);
        }

        $factura->estado = 'Pagado';
        $factura->save();

        return response()->json(['mensaje' => 'Factura pagada correctamente'], 200);
    }
    /**
     * Display a listing of the resource.
     */
    public function index() {}

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $request->validate([
            'empresa' => 'required|string|max:255',
            'nro_factura' => 'required|string|max:255|unique:facturas,nro_factura',
            'CI' => 'required|string|max:255',
            'NombreCompleto' => 'required|string|max:255',
            'Periodo' => 'required|string|max:255',
            'Monto' => 'required|numeric',
            'Estado' => 'in:Pendiente,Pagado',
        ]);

        $factura = Factura::create($request->all());

        return response()->json($factura, 201);
    }

    /**
     * Display the specified resource.
     */
    public function show(Factura $factura)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Factura $factura)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Factura $factura)
    {
        //
    }
}
