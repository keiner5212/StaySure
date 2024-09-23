<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Agregar Habitación - Staysure</title>
		<link rel="stylesheet" href="./css/index/styles.css" />
	</head>
	<body>
		<header>
			<div>
				<img src="./img/menu.png" alt="menu" />
				<img src="./img/home.png" alt="inicio" />
			</div>
			<div>
				<img src="./img/theme.png" alt="tema" />
				<img src="./img/user.png" alt="cuenta" />
			</div>
		</header>
		<main>
			<div class="container">
				<h2>AGREGAR HABITACIÓN</h2>
				<form
					method="post"
				>
					<div class="form-group">
						<label for="titulo">Título de la Habitación</label>
						<input type="text" id="titulo" name="titulo" required />
					</div>
					<div class="form-group">
						<label for="descripcion">Descripción</label>
						<textarea
							id="descripcion"
							name="descripcion"
							rows="4"
							required
						></textarea>
					</div>
					<div class="form-group">
						<label for="pais">Lugar</label>
						<div style="display: flex; gap: 10px;">
							<select id="pais" name="pais" required>
								<option value="Colombia">Colombia</option>
							</select>
							<select id="ciudad" name="ciudad" required>
								<option value="Santa Marta">Santa Marta</option>
								<option value="Bogotá">Bogotá</option>
								<option value="Medellín">Medellín</option>
								<option value="Cali">Cali</option>
								<option value="Barranquilla"
									>Barranquilla</option
								>
								<option value="Cartagena">Cartagena</option>
								<option value="Manizales">Manizales</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="servicios"
							>Selecciona los servicios de la habitación</label
						>
						<select id="servicios" name="servicios" onchange="updateServices(event)">
							<option value="aire_acondicionado"
								>Aire Acondicionado</option
							>
							<option value="piscina">Piscina</option>
							<option value="wifi">WiFi</option>
							<option value="tv">TV</option>
							<option value="cochera">Cochera</option>
							<option value="banios">Baños</option>
							<option value="estufa">Estufa</option>
							<option value="lavadora">Lavadora</option>
							<option value="nevera">Nevera</option>
						</select>
						<div class="selected-services">
						</div>
					</div>
					<div class="form-group">
						<label for="imagen">Seleccionar imágenes</label>
						<input
							type="file"
							id="imagen"
							name="imagen"
							accept="image/*"
							required
						/>
						<img
							id="preview"
							src="#"
							alt="Imagen seleccionada"
							style="display: none;"
						/>
					</div>
					<div class="btn-group">
						<button 
						onclick="sendAjax(event)"
						>Guardar</button>
						<button type="reset">Descartar</button>
					</div>
				</form>
			</div>
		</main>

		<script src="./js/index/index.js"></script>
		<script src="./js/index/Ajax.js"></script>
	</body>
</html>
