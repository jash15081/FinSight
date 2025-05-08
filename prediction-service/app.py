from flask import Flask, request, jsonify
import pickle
import pandas as pd
import socket

# Initialize Flask app
app = Flask(__name__)

def log_instance(endpoint_name):
    hostname = socket.gethostname()
    print(f"📦 Request handled by instance: {hostname} → endpoint: {endpoint_name}")
# === Load models and preprocessing tools ===
with open("model_score.pkl", "rb") as f:
    model_score = pickle.load(f)

with open("model_default.pkl", "rb") as f:
    model_default = pickle.load(f)

with open("scaler.pkl", "rb") as f:
    scaler = pickle.load(f)

with open("model_columns.pkl", "rb") as f:
    model_columns = pickle.load(f)

# === Helper function: preprocess input ===
def preprocess_input(user_input_dict):
    df_input = pd.DataFrame([user_input_dict])
    df_input = pd.get_dummies(df_input)

    # Add missing columns
    for col in model_columns:
        if col not in df_input:
            df_input[col] = 0

    # Ensure column order
    df_input = df_input[model_columns]

    # Scale numerical features
    df_scaled = df_input

    return df_scaled

# === API Endpoint ===
@app.route('/predict', methods=['POST'])
def predict():
    log_instance("predict")
    try:
        user_input = request.get_json()

        # Preprocess input and predict
        processed_input = preprocess_input(user_input)
        credit_score = model_score.predict(processed_input)[0]
        default_prob = model_default.predict_proba(processed_input)[0][1]
        default_label = model_default.predict(processed_input)[0]

        # Build response
        result = {
            "score": round(float(credit_score), 2),
            "default_prob": round(float(default_prob), 3),
            "default": "Yes" if default_label == 1 else "No"
        }

        return jsonify(result)

    except Exception as e:
        return jsonify({"error": str(e)}), 500

# === Run the Flask app ===
if __name__ == '__main__':
    app.run(debug=True,host="0.0.0.0", port=5000)
