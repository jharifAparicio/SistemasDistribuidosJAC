<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('facturas', function (Blueprint $table) {
            $table->increments('nroFactura'); // ID autoincremental
            // Empresa, NroFactura,CI,
            //NombreCompleto, Periodo, Monto,Estado (Pendiente,Pagado)
            $table->string('empresa')->default("CESSA");
            $table->string('ci');
            $table->string('nombreCompleto');
            $table->string('periodo');
            $table->double('monto', 8, 2);
            $table->enum('estado', ['Pendiente', 'Pagado'])->default('Pendiente');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('facturas');
    }
};
