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
            $table->id();
            // Empresa, NroFactura,CI,
            //NombreCompleto, Periodo, Monto,Estado (Pendiente,Pagado)
            $table->string('empresa');
            $table->string('nro_factura')->unique();
            $table->String("CI");
            $table->String('NombreCompleto');
            $table->String("Periodo");
            $table->double('Monto', 8, 2);
            $table->enum('Estado', ['Pendiente', 'Pagado'])->default('Pendiente');
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
