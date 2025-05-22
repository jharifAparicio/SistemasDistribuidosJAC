<?php

namespace App\Http\Controllers;

use App\Models\Titulo;
use Illuminate\Http\Request;

class TituloController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        return Titulo::all();
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        return Titulo::create($request->all());
    }

    /**
     * Display the specified resource.
     */
    public function show(Titulo $titulo)
    {
        return $titulo;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Titulo $titulo)
    {
        $titulo->update($request->all());
        return $titulo;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Titulo $titulo)
    {
        $titulo->delete();
        return response()->json(['message' => 'Titulo deleted successfully']);
    }
}
