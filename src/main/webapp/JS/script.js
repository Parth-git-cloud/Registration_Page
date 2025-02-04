// Data for dynamic filtering
console.log("running");
const countries = {
    India: {
        states: {
            "Maharashtra": ["Mumbai", "Pune", "Nagpur"],
            "Karnataka": ["Bangalore", "Mysore", "Mangalore"]
        }
    },
    USA: {
        states: {
            "California": ["Los Angeles", "San Francisco", "San Diego"],
            "Texas": ["Houston", "Dallas", "Austin"]
        }
    }
};

// Populate states and cities based on selected country and state
document.getElementById("country").addEventListener("change", function() {
    const country = this.value;
    const stateSelect = document.getElementById("state");
    const citySelect = document.getElementById("city");

    // Clear previous options
    stateSelect.innerHTML = "<option value=''>Select State</option>";
    citySelect.innerHTML = "<option value=''>Select City</option>";

    if (country && countries[country]) {
        const states = countries[country].states;
        for (const state in states) {
            const option = document.createElement("option");
            option.value = state;
            option.text = state;
            stateSelect.appendChild(option);
        }
    }
});

// Filter cities based on selected state
document.getElementById("state").addEventListener("change", function() {
    const country = document.getElementById("country").value;
    const state = this.value;
    const citySelect = document.getElementById("city");

    // Clear previous options
    citySelect.innerHTML = "<option value=''>Select City</option>";

    if (country && state && countries[country] && countries[country].states[state]) {
        const cities = countries[country].states[state];
        cities.forEach(city => {
            const option = document.createElement("option");
            option.value = city;
            option.text = city;
            citySelect.appendChild(option);
        });
    }
});

document.addEventListener("DOMContentLoaded", function () {
    console.log("DOM fully loaded");

    const countrySelect = document.getElementById("country");
    const stateSelect = document.getElementById("state");
    const dobInput = document.getElementById("dob");

    // Check if elements exist before adding event listeners
    if (countrySelect) {
        countrySelect.addEventListener("change", function () {
            console.log("Country changed!");
        });
    } else {
        console.error("Country select element not found!");
    }

    if (stateSelect) {
        stateSelect.addEventListener("change", function () {
            console.log("State changed!");
        });
    } else {
        console.error("State select element not found!");
    }

    if (dobInput) {
        dobInput.addEventListener("change", function () {
            console.log("DOB changed!");
        });
    } else {
        console.error("DOB input element not found!");
    }
});


// Calculate age based on Date of Birth
document.getElementById("dob").addEventListener("change", function () {
    const dob = new Date(this.value);
    const today = new Date();

    let age = today.getFullYear() - dob.getFullYear(); // Use let instead of const
    const month = today.getMonth() - dob.getMonth();
    if (month < 0 || (month === 0 && today.getDate() < dob.getDate())) {
        age--; // Now this will work
    }
    document.getElementById("age").value = age;
});
