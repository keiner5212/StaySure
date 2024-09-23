async function sendAjax(event) {
	event.preventDefault()
	const http = new XMLHttpRequest();
	const url = "http://localhost:8080/Staysure/HabitacionSrv";

	const titulo = document.getElementById("titulo").value;
	const descripcion = document.getElementById("descripcion").value;
	const pais = document.getElementById("pais").value;
	const ciudad = document.getElementById("ciudad").value;
	const imageUrl = await postImage();
	const temp = document.querySelectorAll(".selected-services span");
	console.log(temp);
	const services_array =
		(temp && temp.length > 0) ? [...temp].map((element) => element.outerText) : [];

	http.onreadystatechange = function () {
		if (http.readyState === 4 && http.status === 200) {
		}
	};

	const data = JSON.stringify({
		titulo,
		descripcion,
		pais,
		ciudad,
		services_array,
		imageUrl,
	});

	http.open("POST", url);
	http.setRequestHeader("Content-Type", "application/json");
	http.send(data);
}

const cloudName = "ep0zgjfc";
const uploadPreset = "ep0zgjfc";
const apiKey = "697942456234798";

async function postImage() {
	const fileInput = document.getElementById("imagen");
	const file = fileInput.files[0];
	if (file) {
		return await uploadImageToCloudinary(file);
	}
}

async function uploadImageToCloudinary(file) {
	const url = `https://api.cloudinary.com/v1_1/${cloudName}/upload`;

	const formData = new FormData();
	formData.append("file", file);
	formData.append("upload_preset", uploadPreset);
	formData.append("api_key", apiKey);

	try {
		const response = await fetch(url, {
			method: "POST",
			body: formData,
		});

		if (!response.ok) {
			throw new Error("Error uploading image");
		}

		const result = await response.json();
		return result.secure_url;
	} catch (error) {
		console.error("Error uploading image:", error);
	}
}
