<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Titulo extends Model
{
    /** @use HasFactory<\Database\Factories\TituloFactory> */
    use HasFactory;
    protected $fillable = [
        'ci',
        'nombres',
        'PrimerApellido',
        'SegundoApellido',
        'Titulo'
    ];
    protected $table = 'titulos';
}
