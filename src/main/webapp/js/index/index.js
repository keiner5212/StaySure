// Previsualización de imagen
const inputFile = document.getElementById("imagen");
const previewImg = document.getElementById("preview");

inputFile.addEventListener("change", (event) => {
	const file = event.target.files[0];
	if (file) {
		const reader = new FileReader();
		reader.onload = function (e) {
			previewImg.src = e.target.result;
			previewImg.style.display = "block";
		};
		reader.readAsDataURL(file);
	}
});

// Servicios seleccionados

function updateServices(e) {
	const selected = e.target.value;

    if(document.getElementById(selected)) return

	const selectedServicesContainer = document.querySelector(
		".selected-services"
	);

	const chipdiv = document.createElement("div");
	chipdiv.setAttribute("class", "service-chip");
	chipdiv.setAttribute("id", selected);
	chipdiv.innerHTML = `
        <span>${selected}</span>
        <button type="button">x</button>`;

	selectedServicesContainer.append(chipdiv);

	setTimeout(() => {
		document.getElementById(selected).addEventListener("click", (e) => {
			e.target.closest(".service-chip").remove();
		});
	}, 100);
}
